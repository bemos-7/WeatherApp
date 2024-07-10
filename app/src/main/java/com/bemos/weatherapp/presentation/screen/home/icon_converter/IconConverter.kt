package com.bemos.weatherapp.presentation.screen.home.icon_converter

import com.bemos.weatherapp.R

class IconConverter {

    fun iconConvert(
        textCondition: String,
        time: Int = 5
    ) : Int {
        if (time in 5..18) {
            return when(textCondition.toLowerCase().trim()) {
                "sunny" -> R.drawable.sun
                "partly cloudy" -> R.drawable.cloud_sun
                "clear" -> R.drawable.sun
                "moderate or heavy rain with thunder" -> R.drawable.thunder
                "mist" -> R.drawable.mist_second
                "overcast" -> R.drawable.clouds
                "patchy rain nearby" -> R.drawable.group_8
                "cloudy" -> R.drawable.clouds
                "heavy rain" -> R.drawable.heavy_rain_and_storm
                "moderate rain" -> R.drawable.clouds_rain
                "light rain shower" -> R.drawable.group_8
                "fog" -> R.drawable.fog
                "patchy light drizzle" -> R.drawable.clouds_rain
                "light rain" -> R.drawable.light_rain
                "patchy rain nearby" -> R.drawable.group_8
                "light drizzle" -> R.drawable.light_drizzle
                "patchy light rain" -> R.drawable.group_8
                else -> { R.drawable.baseline_arrow_circle_down_24_s }
            }
        } else {
            return when(textCondition.toLowerCase().trim()) {
                "sunny" -> R.drawable.full_moon_second
                "partly cloudy" -> R.drawable.night
                "clear" -> R.drawable.clear
                "moderate or heavy rain with thunder" -> R.drawable.thunder
                "mist" -> R.drawable.mist_second
                "overcast" -> R.drawable.clouds
                "patchy rain nearby" -> R.drawable.night_rain
                "cloudy" -> R.drawable.clouds
                "heavy rain" -> R.drawable.heavy_rain_and_storm
                "moderate rain" -> R.drawable.clouds_rain
                "light rain shower" -> R.drawable.group_8
                "fog" -> R.drawable.fog
                "patchy light drizzle" -> R.drawable.clouds_rain
                "light rain" -> R.drawable.light_rain
                "patchy rain nearby" -> R.drawable.night_rain
                "light drizzle" -> R.drawable.light_drizzle
                "patchy light rain" -> R.drawable.night_rain
                else -> { R.drawable.baseline_arrow_circle_down_24_s }
            }
        }

    }

}