package com.bemos.weatherapp.presentation.screen.details_city.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.data.remote.retrofit.weather.models.Hour
import com.bemos.domain.model.Location
import com.bemos.domain.model.weather_models.HourDomain
import com.bemos.domain.use_cases.GetLocationsByCityUseCase
import com.bemos.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.domain.use_cases.InsertLocationUseCase
import com.bemos.weatherapp.presentation.screen.details_city.model.WeatherByTheHour
import com.bemos.weatherapp.presentation.screen.details_city.model.WeatherDetailsAndMore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsScreenViewModel(
    private val getWeatherAndWeekUseCase: GetWeatherAndWeekUseCase,
    private val insertLocationUseCase: InsertLocationUseCase,
    private val getLocationByCityUseCase: GetLocationsByCityUseCase
) : ViewModel() {

    val weatherAndForecast = MutableStateFlow(
        WeatherDetailsAndMore(
            city = "",
            temp = "",
            weather = "",
            forecastDay = listOf(),
            image = ""
        )
    )

    val weatherByTheHour = MutableStateFlow<List<WeatherByTheHour>>(
        listOf()
    )

    val insertChecker = MutableStateFlow(false)

    val progressBarState = MutableStateFlow(false)

    suspend fun getWeatherAndForecast(
        city: String
    ) = viewModelScope.launch {
        progressBarState.update {
            false
        }

        val response = getWeatherAndWeekUseCase.execute(
            city
        )

        if (response.isSuccessful) {
            weatherAndForecast.update {
                WeatherDetailsAndMore(
                    city = response.body()!!.locationDomain.name,
                    temp = response.body()!!.currentDomain.temp_c.toString(),
                    weather = response.body()!!.currentDomain.conditionDomain.text,
                    forecastDay = response.body()!!.forecastDomain.forecastdayDomain,
                    image = response.body()!!.currentDomain.conditionDomain.icon
                )
            }
            progressBarState.update {
                true
            }

            val weatherByTheHourList = mutableListOf<HourDomain>()

            var time = ""

            val weatherAndTime = mutableListOf<WeatherByTheHour>()

            response.body()!!.forecastDomain.forecastdayDomain.forEach { forecastday ->
                forecastday.hourDomain.forEach {
                    if (weatherByTheHourList.size <= 24) {

                        val timePattern = """(\d{2}):(\d{2})""".toRegex()

                        val match = timePattern.find(it.time)

                        if (match != null) {
                            var hour = match.groupValues[1]

                            if (hour.toInt() >= 12) {
                                hour += " PM"
                            } else {
                                hour += " AM"
                            }

                            time = hour
                        }

                        weatherByTheHourList.add(it)

                        weatherAndTime.add(
                            WeatherByTheHour(
                                it,
                                time
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

    suspend fun insertLocation(
        city: String
    ) {
        viewModelScope.launch {
            insertLocationUseCase.execute(
                Location(
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
    ) = viewModelScope.launch {

        getLocationByCityUseCase.execute(city)
            .collect { list ->
                insertChecker.update {
                    list.isEmpty()
                }
            }
    }

    fun clearWeatherData() {
        weatherAndForecast.update {
            WeatherDetailsAndMore(
                "",
                "",
                "",
                listOf(),
                ""
            )
        }
        weatherByTheHour.update {
            listOf()
        }
    }

}