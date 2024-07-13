package com.bemos.details_city.vm

import androidx.lifecycle.ViewModel
import com.bemos.domain.model.weather_models.ForecastdayDomain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class DetailsWeatherIntentViewModel : ViewModel() {

    val weather = MutableStateFlow(
        ""
    )

    val forecastDay = MutableStateFlow<ForecastdayDomain?>(null)

    fun updateCityDate(
        city: String
    ) {
        weather.update {
            city
        }
    }

    fun updateForecastDay(
        forecastDayDomain: ForecastdayDomain
    ) {
        forecastDay.update {
            forecastDayDomain
        }
    }

}