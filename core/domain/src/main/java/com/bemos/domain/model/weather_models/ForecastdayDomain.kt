package com.bemos.domain.model.weather_models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForecastdayDomain(
    val astroDomain: AstroDomain,
    val date: String,
    val date_epoch: Int,
    val dayDomain: DayDomain,
    val hourDomain: List<HourDomain>
) : Parcelable