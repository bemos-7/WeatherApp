package com.bemos.weatherapp.presentation.screen.details_city.vm

import androidx.lifecycle.ViewModel
import com.bemos.weatherapp.presentation.screen.details_city.model.WeatherDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class DetailsWeatherIntentViewModel : ViewModel() {

    val weather = MutableStateFlow(
        ""
    )

    fun updateCityDate(
        city: String
    ) {
        weather.update {
            city
        }
    }

}