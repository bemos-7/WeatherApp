package com.bemos.domain.model.weather_models

data class WeatherDomain(
    val currentDomain: CurrentDomain,
    val forecastDomain: ForecastDomain,
    val locationDomain: LocationDomain
)