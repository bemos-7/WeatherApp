package com.bemos.weatherapp.presentation.screen.details_city.model

import com.bemos.data.remote.retrofit.weather.models.Hour
import com.bemos.domain.model.weather_models.HourDomain

data class WeatherByTheHour(
    val hour: HourDomain,
    val time: String
)