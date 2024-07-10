package com.bemos.weatherapp.presentation.screen.detail_city_future.model

import com.bemos.domain.model.weather_models.ForecastdayDomain
import com.bemos.domain.model.weather_models.HourDomain

data class ForecastDayCF(
    val forecastDayDomain: ForecastdayDomain,
    val weatherHour: List<WeatherHour>,
)

data class WeatherHour(
    val hourDomain: HourDomain,
    val normalTime: String,
    val listTime: String
)