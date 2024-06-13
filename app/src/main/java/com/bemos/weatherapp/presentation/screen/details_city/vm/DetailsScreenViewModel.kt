package com.bemos.weatherapp.presentation.screen.details_city.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.weatherapp.domain.use_cases.GetWeatherUseCase
import com.bemos.weatherapp.presentation.screen.details_city.model.WeatherDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DetailsScreenViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    val weather = MutableStateFlow(
        WeatherDetails(
            city = "",
            temp = "",
            weather = ""
        )
    )

    suspend fun getWeatherByCity(
        city: String
    ) {
        viewModelScope.launch {
            val response = getWeatherUseCase.execute(
                city
            )

            if (response.isSuccessful) {
                weather.value = WeatherDetails(
                    temp = response.body()!!.current.temp_c.toString(),
                    city = response.body()!!.location.name,
                    weather = response.body()!!.current.condition.text
                )
            }
        }
    }

}