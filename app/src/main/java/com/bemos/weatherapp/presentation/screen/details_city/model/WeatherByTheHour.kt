package com.bemos.weatherapp.presentation.screen.details_city.model

import com.bemos.weatherapp.data.remote.retrofit.weather.models.Hour

data class WeatherByTheHour(
    val hour: List<Hour>,
    val time: List<String>
)