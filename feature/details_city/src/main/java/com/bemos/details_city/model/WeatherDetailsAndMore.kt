package com.bemos.details_city.model

data class WeatherDetailsAndMore(
    val city: String,
    val temp: String,
    val weather: String,
    val forecastDay: List<com.bemos.domain.model.weather_models.ForecastdayDomain>,
    val image: String,
    val icon: Int,
)

data class ForecastDayAndIcon(
    val forecastDay: com.bemos.domain.model.weather_models.ForecastdayDomain,
    val icon: Int
)