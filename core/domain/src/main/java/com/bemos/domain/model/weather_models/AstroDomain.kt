package com.bemos.domain.model.weather_models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AstroDomain(
    val is_moon_up: Int,
    val is_sun_up: Int,
    val moon_illumination: Int,
    val moon_phase: String,
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
) : Parcelable