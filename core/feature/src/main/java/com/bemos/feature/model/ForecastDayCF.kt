package com.bemos.feature.model

import com.bemos.domain.model.weather_models.ForecastdayDomain
import com.bemos.domain.model.weather_models.HourDomain

data class ForecastDayCF(
    val forecastDayDomain: ForecastdayDomain,
    val weatherHour: List<WeatherHour>,
    val icon: Int
)

data class WeatherHour(
    val hourDomain: HourDomain,
    val normalTime: String,
    val listTime: String,
    val icon: Int
)