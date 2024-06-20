package com.bemos.weatherapp.presentation.screen.details_city.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.weatherapp.data.remote.retrofit.weather.models.Hour
import com.bemos.weatherapp.domain.model.Location
import com.bemos.weatherapp.domain.use_cases.GetLocationByCityUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherUseCase
import com.bemos.weatherapp.domain.use_cases.InsertLocationUseCase
import com.bemos.weatherapp.presentation.screen.details_city.model.WeatherDetailsAndMore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsScreenViewModel(
    private val getWeatherAndWeekUseCase: GetWeatherAndWeekUseCase,
    private val insertLocationUseCase: InsertLocationUseCase,
    private val getLocationByCityUseCase: GetLocationByCityUseCase
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

    val weatherByTheHour = MutableStateFlow<List<Hour>>(
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

            response.body()!!.forecast.forecastday.forEach { forecastday ->
                forecastday.hour.forEach {
                    if (weatherByTheHourList.size <= 24) {

                        val timePattern = """(\d{2}):(\d{2})""".toRegex()

                        val match = timePattern.find(it.time)

                        weatherByTheHourList.add(it)
                    }
                }
            }

            weatherByTheHour.update {
                weatherByTheHourList
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

        var location = listOf<Location>()

        getLocationByCityUseCase.execute(city)
            .collect { list ->
                location = list
            }

        if (location.isEmpty()) {
            insertChecker.update {
                false
            }
        } else {
            insertChecker.update {
                true
            }
        }
    }

}