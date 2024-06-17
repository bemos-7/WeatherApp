package com.bemos.weatherapp.presentation.screen.details_city.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.weatherapp.data.remote.retrofit.weather.models.Hour
import com.bemos.weatherapp.domain.model.Location
import com.bemos.weatherapp.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherUseCase
import com.bemos.weatherapp.domain.use_cases.InsertLocationUseCase
import com.bemos.weatherapp.presentation.screen.details_city.model.WeatherDetailsAndMore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsScreenViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val getWeatherAndWeekUseCase: GetWeatherAndWeekUseCase,
    private val insertLocationUseCase: InsertLocationUseCase
) : ViewModel() {

    val weatherAndForecast = MutableStateFlow(
        WeatherDetailsAndMore(
            city = "",
            temp = "",
            weather = "",
            forecastDay = listOf()
        )
    )

    val weatherByTheHour = MutableStateFlow<List<Hour>>(
        listOf()
    )

    val insertChecker = MutableStateFlow(
        true
    )

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
                    forecastDay = response.body()!!.forecast.forecastday
                )
            }

            val weatherByTheHourList = mutableListOf<Hour>()

            response.body()!!.forecast.forecastday.forEach { forecastday ->
                forecastday.hour.forEach {
                    if (weatherByTheHourList.size <= 24) {
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
    ) = viewModelScope.launch {
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