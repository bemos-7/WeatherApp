package com.bemos.weatherapp.data.remote.retrofit.models

data class Weather(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)