package com.bemos.weatherapp.presentation.screen.main_activity

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.bemos.domain.model.weather_models.ForecastdayDomain

//class ForecastDayDomainNavType : NavType<ForecastdayDomain>(true) {
//    override fun get(bundle: Bundle, key: String): ForecastdayDomain? {
//        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            bundle.getParcelable(key, ForecastdayDomain::class.java)
//        } else {
//            @Suppress("DEPRECATION")
//            bundle.getParcelable(key)
//        }
//    }
//
//    override fun parseValue(value: String): ForecastdayDomain {
//        TODO("Not yet implemented")
//    }
//
//    override fun put(bundle: Bundle, key: String, value: ForecastdayDomain) {
//        bundle.putParcelable(key, value)
//    }
//
//
//}