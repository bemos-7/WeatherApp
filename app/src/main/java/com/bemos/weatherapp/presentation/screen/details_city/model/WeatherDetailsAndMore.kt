package com.bemos.weatherapp.presentation.screen.details_city.model

import com.bemos.weatherapp.data.remote.retrofit.weather.models.Forecastday

data class WeatherDetailsAndMore(
    val city: String,
    val temp: String,
    val weather: String,
    val forecastDay: List<Forecastday>,
    val image: String
)