package com.bemos.weatherapp.presentation.screen.home.icon_converter

import com.bemos.weatherapp.R

class IconConverter {

    fun iconConvert(
        textCondition: String,
        time: Int = 5
    ) : Int {
        if (time > 4 && time < 18) {
            return when(textCondition.toLowerCase().trim()) {
                "sunny" -> R.drawable.sun
                "partly cloudy" -> R.drawable.cloud_sun
                "clear" -> R.drawable.sun
                "moderate or heavy rain with thunder" -> R.drawable.thunder
                "mist" -> R.drawable.mist_second
                "overcast" -> R.drawable.clouds
                "patchy rain nearby" -> R.drawable.group_8
                "cloudy" -> R.drawable.clouds
                "heavy rain" -> R.drawable.clouds_rain
                "moderate rain" -> R.drawable.clouds_rain
                else -> { R.drawable.sun }
            }
        } else {
            return when(textCondition.toLowerCase().trim()) {
                "sunny" -> R.drawable.sun
                "partly cloudy" -> R.drawable.night
                "clear" -> R.drawable.clear
                "moderate or heavy rain with thunder" -> R.drawable.thunder
                "mist" -> R.drawable.mist_second
                "overcast" -> R.drawable.clouds
                "patchy rain nearby" -> R.drawable.night_rain
                "cloudy" -> R.drawable.clouds
                "heavy rain" -> R.drawable.clouds_rain
                "moderate rain" -> R.drawable.clouds_rain
                else -> { R.drawable.full_moon_second }
            }
        }

    }

}