package com.bemos.details_city.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.bemos.details_city.model.WeatherByTheHourVisibleMode
import com.bemos.domain.model.weather_models.HourDomain
import com.bemos.feature.model.ForecastDayAndIcon
import com.bemos.domain.use_cases.CheckInternetUseCase
import com.bemos.domain.use_cases.GetLocationsByCityUseCase
import com.bemos.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.domain.use_cases.InsertLocationUseCase
import com.bemos.feature.model.WeatherByTheHour
import com.bemos.feature.model.WeatherDetailsAndMore
import com.bemos.domain.use_cases.IconConvertUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class DetailsScreenViewModel(
    private val getWeatherAndWeekUseCase: GetWeatherAndWeekUseCase,
    private val insertLocationUseCase: InsertLocationUseCase,
    private val getLocationByCityUseCase: GetLocationsByCityUseCase,
    private val checkInternetUseCase: CheckInternetUseCase,
    private val iconConvertUseCase: IconConvertUseCase
) : ViewModel() {

    val weatherAndForecast = MutableStateFlow(
        com.bemos.feature.model.WeatherDetailsAndMore(
            city = "",
            temp = "",
            weather = "",
            forecastDay = listOf(),
            image = "",
            icon = 0
        )
    )

    val forecastDayAndIcon = MutableStateFlow<List<com.bemos.feature.model.ForecastDayAndIcon>>(listOf())

    val weatherByTheHour = MutableStateFlow<List<com.bemos.feature.model.WeatherByTheHour>>(
        listOf()
    )

    val insertChecker = MutableStateFlow(false)

    val progressBarState = MutableStateFlow(false)

    val networkState = MutableStateFlow(true)

    val forecastDayState = MutableStateFlow(
        WeatherByTheHourVisibleMode(
            null,
            false
        )
    )

    suspend fun getWeatherAndForecast(
        city: String
    ) = viewModelScope.launch {
        if (networkState.value) {
            progressBarState.update {
                false
            }

            val response = getWeatherAndWeekUseCase.execute(
                city
            )

            val timePattern = """(\d{2}):(\d{2})""".toRegex()
            val timeFirstPattern = """(\d{1}):(\d{2})""".toRegex()

            if (response.isSuccessful) {

                var timeLocal = timePattern.find(response.body()!!.locationDomain.localtime)

                if (timeLocal == null) {
                    timeLocal = timeFirstPattern.find(response.body()!!.locationDomain.localtime)
                }

                weatherAndForecast.update {
                    com.bemos.feature.model.WeatherDetailsAndMore(
                        city = response.body()!!.locationDomain.name,
                        temp = response.body()!!.currentDomain.temp_c.toString(),
                        weather = response.body()!!.currentDomain.conditionDomain.text,
                        forecastDay = response.body()!!.forecastDomain.forecastdayDomain,
                        image = response.body()!!.currentDomain.conditionDomain.icon,
                        icon = iconConvertUseCase.execute(
                            response.body()!!.currentDomain.conditionDomain.code,
                            timeLocal!!.groupValues[1].toInt()
                        )
                    )
                }

                val forecastDayIcon = mutableListOf<com.bemos.feature.model.ForecastDayAndIcon>()

                var forecastIcon = 0

                response.body()!!.forecastDomain.forecastdayDomain.forEach { forecast ->

                    forecast.hourDomain.forEach {
                        forecastIcon = iconConvertUseCase.execute(
                            it.conditionDomain.code
                        )
                    }
                    forecastDayIcon.add(
                        com.bemos.feature.model.ForecastDayAndIcon(
                            forecast,
                            forecastIcon
                        )
                    )
                }

                forecastDayAndIcon.update {
                    forecastDayIcon
                }

                progressBarState.update {
                    true
                }

                val weatherByTheHourList = mutableListOf<com.bemos.domain.model.weather_models.HourDomain>()

                var time = ""
                var cityTime = ""

                val weatherAndTime = mutableListOf<com.bemos.feature.model.WeatherByTheHour>()

                response.body()!!.forecastDomain.forecastdayDomain.forEach { forecastday ->
                    forecastday.hourDomain.forEach {
                        if (weatherByTheHourList.size <= 24) {

                            val match = timePattern.find(it.time)

                            if (match != null) {
                                var hour = match.groupValues[1]

                                if (hour.toInt() >= 12) {
                                    hour += " PM"
                                    cityTime = timeLocal!!.groupValues[1] + " PM"
                                } else {
                                    hour += " AM"
                                    cityTime = timeLocal!!.groupValues[1] + " AM"
                                }

                                time = hour
                            }

                            weatherByTheHourList.add(it)

                            val icon = iconConvertUseCase.execute(
                                it.conditionDomain.code,
                                match!!.groupValues[1].toInt()
                            )

                            weatherAndTime.add(
                                com.bemos.feature.model.WeatherByTheHour(
                                    it,
                                    time,
                                    icon,
                                    cityTime
                                )
                            )
                        }
                    }
                }

                weatherByTheHour.update {
                    weatherAndTime
                }
            }
        }
    }

    suspend fun insertLocation(
        city: String
    ) {
        viewModelScope.launch {
            insertLocationUseCase.execute(
                com.bemos.domain.model.LocationDaoDomain(
                    city = city
                )
            )

            insertChecker.update {
                false
            }
        }
    }

    fun insertLocationRunWithScope(city: String) {
        viewModelScope.launch {
            insertLocation(city)
        }
    }

    fun getLocationByCity(
        city: String
    ) {
        viewModelScope.launch {
            if (networkState.value) {
                getLocationByCityUseCase.execute(city)
                    .collect { list ->
                        insertChecker.update {
                            list.isEmpty()
                        }
                    }
            }
        }
    }

    fun controlNavigation(navController: NavController) {
        if (networkState.value) {
            navController.navigate("home")
        }
    }

    fun checkInternet() {
        networkState.update {
            checkInternetUseCase.execute()
        }
    }

    fun clearWeatherData() {
        weatherAndForecast.update {
            com.bemos.feature.model.WeatherDetailsAndMore(
                "",
                "",
                "",
                listOf(),
                "",
                0
            )
        }
        weatherByTheHour.update {
            listOf()
        }
    }

    fun updateWeatherByTheHourVisibleMode(
        weatherByTheHourVisibleMode: WeatherByTheHourVisibleMode
    ) {
        forecastDayState.update {
            weatherByTheHourVisibleMode
        }
    }

}