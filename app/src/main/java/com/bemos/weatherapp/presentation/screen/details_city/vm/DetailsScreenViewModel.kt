package com.bemos.weatherapp.presentation.screen.details_city.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.weatherapp.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherUseCase
import com.bemos.weatherapp.presentation.screen.details_city.model.WeatherDetails
import com.bemos.weatherapp.presentation.screen.details_city.model.WeatherDetailsAndMore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsScreenViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val getWeatherAndWeekUseCase: GetWeatherAndWeekUseCase
) : ViewModel() {

    val weather = MutableStateFlow(
        WeatherDetails(
            city = "",
            temp = "",
            weather = ""
        )
    )

    val weatherAndMore = MutableStateFlow(
        WeatherDetailsAndMore(
            city = "",
            temp = "",
            weather = "",
        )
    )

    suspend fun getWeatherByCity(
        city: String
    ) = viewModelScope.launch {
        val response = getWeatherUseCase.execute(
        city
        )

        if (response.isSuccessful) {
        weather.update {
                WeatherDetails(
                    temp = response.body()!!.current.temp_c.toString(),
                    city = response.body()!!.location.name,
                    weather = response.body()!!.current.condition.text
                )
            } 
        }
    }

    suspend fun getWeatherAndWeek(
        city: String
    ) = viewModelScope.launch {
        val response = getWeatherAndWeekUseCase.execute(
            city
        )

        if (response.isSuccessful) {
            weatherAndMore.update {
                WeatherDetailsAndMore(
                    city = response.body()!!.location.name,
                    temp = response.body()!!.current.temp_c.toString(),
                    weather = response.body()!!.current.condition.text,
                )
            }
        }
    }

}