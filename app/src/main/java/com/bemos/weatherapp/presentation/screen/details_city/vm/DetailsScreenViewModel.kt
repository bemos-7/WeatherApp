package com.bemos.weatherapp.presentation.screen.details_city.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.weatherapp.data.remote.retrofit.weather.models.Hour
import com.bemos.weatherapp.domain.model.Location
import com.bemos.weatherapp.domain.use_cases.GetLocationsByCityUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.weatherapp.domain.use_cases.InsertLocationUseCase
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

    suspend fun getWeatherAndForecast(
        city: String
    ) = viewModelScope.launch {
        val response = getWeatherAndWeekUseCase.execute(
            city
        )

        if (response.isSuccessful) {
            weatherAndForecast.update {
                WeatherDetailsAndMore(
                    city = response.body()!!.location.name,
                    temp = response.body()!!.current.temp_c.toString(),
                    weather = response.body()!!.current.condition.text,
                    forecastDay = response.body()!!.forecast.forecastday,
                    image = response.body()!!.current.condition.icon
                )
            }

            val weatherByTheHourList = mutableListOf<Hour>()

            var time = ""

            val weatherAndTime = mutableListOf<WeatherByTheHour>()

            response.body()!!.forecast.forecastday.forEach { forecastday ->
                forecastday.hour.forEach {
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

}