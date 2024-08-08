package com.bemos.feature.model

import com.bemos.domain.model.weather_models.HourDomain

data class WeatherByTheHour(
    val hour: HourDomain,
    val time: String,
    val icon: Int,
    val cityTime: String
)