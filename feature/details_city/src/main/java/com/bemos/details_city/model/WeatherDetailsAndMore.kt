package com.bemos.details_city.model

import com.bemos.data.remote.retrofit.weather.models.Forecastday
import com.bemos.domain.model.weather_models.ForecastdayDomain

data class WeatherDetailsAndMore(
    val city: String,
    val temp: String,
    val weather: String,
    val forecastDay: List<ForecastdayDomain>,
    val image: String,
    val icon: Int,
)

data class ForecastDayAndIcon(
    val forecastDay: ForecastdayDomain,
    val icon: Int
)