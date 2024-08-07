package com.bemos.details_city.model

import com.bemos.domain.model.weather_models.HourDomain

data class WeatherByTheHour(
    val hour: com.bemos.domain.model.weather_models.HourDomain,
    val time: String,
    val icon: Int,
    val cityTime: String
)