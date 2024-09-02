package com.bemos.details_city.model

import com.bemos.feature.model.WeatherByTheHour

data class WeatherByTheHourVisibleMode(
    val weatherByTheHour: WeatherByTheHour?,
    val isVisible: Boolean
)