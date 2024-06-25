package com.bemos.weatherapp.data.remote.retrofit.weather.models

data class Weather(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)