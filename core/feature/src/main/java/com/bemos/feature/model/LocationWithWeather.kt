package com.bemos.feature.model

import com.bemos.domain.model.LocationDaoDomain
import com.bemos.domain.model.weather_models.CurrentDomain

data class LocationWithWeather(
    val location: LocationDaoDomain,
    val weather: CurrentDomain
)