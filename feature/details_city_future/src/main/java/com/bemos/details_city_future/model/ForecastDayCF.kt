package com.bemos.details_city_future.model

import com.bemos.domain.model.weather_models.ForecastdayDomain
import com.bemos.domain.model.weather_models.HourDomain

data class ForecastDayCF(
    val forecastDayDomain: com.bemos.domain.model.weather_models.ForecastdayDomain,
    val weatherHour: List<WeatherHour>,
    val icon: Int
)

data class WeatherHour(
    val hourDomain: com.bemos.domain.model.weather_models.HourDomain,
    val normalTime: String,
    val listTime: String,
    val icon: Int
)