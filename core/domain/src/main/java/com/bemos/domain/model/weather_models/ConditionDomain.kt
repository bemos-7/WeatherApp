package com.bemos.domain.model.weather_models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConditionDomain(
    val code: Int,
    val icon: String,
    val text: String
) : Parcelable