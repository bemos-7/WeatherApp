package com.bemos.weatherapp.icon_converter

import com.bemos.domain.repositories.IconConverterRepository
import com.bemos.weatherapp.R

class IconConverterImpl : IconConverterRepository {

    override fun iconConvert(
        code: Int,
        time: Int
    ) : Int {
        if (time in 5..18) {
            return when(code) {
                1000 -> R.drawable.sun
                1003 -> R.drawable.cloud_sun
                1006 -> R.drawable.clouds
                1009 -> R.drawable.clouds
                1030 -> R.drawable.mist_second
                1063 -> R.drawable.heavy_rain_at_times
                1066 -> R.drawable.patchy_snow_possible
                1069 -> R.drawable.patchy_sleet_possible
                1072 -> R.drawable.patchy_freezing_drizzle_possible
                1087 -> R.drawable.thundery_outbreaks_possible
                1114 -> R.drawable.blowing_snow
                1117 -> R.drawable.blizzard
                1135 -> R.drawable.fog_two
                1147 -> R.drawable.freezing_fog
                1150 -> R.drawable.patchy_light_drizzle
                1153 -> R.drawable.patchy_light_drizzle
                1168 -> R.drawable.patchy_freezing_drizzle_possible
                1171 -> R.drawable.patchy_light_drizzle
                1180 -> R.drawable.patchy_light_rain
                1183 -> R.drawable.light_rain
                1186 -> R.drawable.patchy_light_rain
                1189 -> R.drawable.light_rain
                1192 -> R.drawable.heavy_rain_at_times
                1195 -> R.drawable.heavy_rain
                1198 -> R.drawable.patchy_freezing_drizzle_possible
                1201 -> R.drawable.patchy_freezing_drizzle_possible
                1204 -> R.drawable.light_sleet
                1207 -> R.drawable.light_sleet
                1210 -> R.drawable.patchy_snow_possible
                1213 -> R.drawable.light_snow
                1216 -> R.drawable.patchy_snow_possible
                1219 -> R.drawable.light_snow
                1222 -> R.drawable.patchy_heavy_snow
                1225 -> R.drawable.heavy_snow
                1237 -> R.drawable.ice_pellets
                1240 -> R.drawable.patchy_light_rain
                1243 -> R.drawable.heavy_rain_at_times
                1246 -> R.drawable.torrential_rain_shower
                1249 -> R.drawable.patchy_sleet_possible
                1252 -> R.drawable.moderate_or_heavy_sleet_showers
                1255 -> R.drawable.patchy_snow_possible
                1258 -> R.drawable.patchy_heavy_snow
                1261 -> R.drawable.light_showers_of_ice_pellets
                1264 -> R.drawable.moderate_or_heavy_showers_of_ice_pellets
                1273 -> R.drawable.thundery_outbreaks_possible
                1276 -> R.drawable.thunder
                1279 -> R.drawable.patchy_light_snow_with_thunder
                1282 -> R.drawable.moderate_or_heavy_snow_with_thunder
                else -> {
                    R.drawable.baseline_arrow_circle_down_24_s
                }
            }
        } else {
            return when(code) {
                1000 -> R.drawable.clear
                1003 -> R.drawable.night
                1006 -> R.drawable.clouds
                1009 -> R.drawable.clouds
                1030 -> R.drawable.mist_second
                1063 -> R.drawable.night_rain
                1066 -> R.drawable.patchy_snow_possible_night
                1069 -> R.drawable.patchy_sleet_possible_night
                1072 -> R.drawable.patchy_freezing_drizzle_possible
                1087 -> R.drawable.thundery_outbreaks_possible_night
                1114 -> R.drawable.blowing_snow
                1117 -> R.drawable.blizzard
                1135 -> R.drawable.fog_two
                1147 -> R.drawable.freezing_fog
                1150 -> R.drawable.patchy_light_drizzle
                1153 -> R.drawable.patchy_light_drizzle
                1168 -> R.drawable.patchy_freezing_drizzle_possible
                1171 -> R.drawable.patchy_light_drizzle
                1180 -> R.drawable.patchy_light_rain_night
                1183 -> R.drawable.light_rain
                1186 -> R.drawable.patchy_light_rain_night
                1189 -> R.drawable.light_rain
                1192 -> R.drawable.night_rain
                1195 -> R.drawable.heavy_rain
                1198 -> R.drawable.patchy_freezing_drizzle_possible
                1201 -> R.drawable.patchy_freezing_drizzle_possible
                1204 -> R.drawable.light_sleet
                1207 -> R.drawable.light_sleet
                1210 -> R.drawable.patchy_snow_possible_night
                1213 -> R.drawable.light_snow
                1216 -> R.drawable.patchy_snow_possible_night
                1219 -> R.drawable.light_snow
                1222 -> R.drawable.patchy_heavy_snow
                1225 -> R.drawable.heavy_snow
                1237 -> R.drawable.ice_pellets
                1240 -> R.drawable.patchy_light_rain_night
                1243 -> R.drawable.night_rain
                1246 -> R.drawable.torrential_rain_shower_night
                1249 -> R.drawable.patchy_sleet_possible_night
                1252 -> R.drawable.moderate_or_heavy_sleet_showers_night
                1255 -> R.drawable.patchy_snow_possible_night
                1258 -> R.drawable.patchy_heavy_snow_night
                1261 -> R.drawable.light_showers_of_ice_pellets
                1264 -> R.drawable.moderate_or_heavy_showers_of_ice_pellets_night
                1273 -> R.drawable.thundery_outbreaks_possible_night
                1276 -> R.drawable.thunder
                1279 -> R.drawable.patchy_light_snow_with_thunder_night
                1282 -> R.drawable.moderate_or_heavy_snow_with_thunder
                else -> {
                    R.drawable.baseline_arrow_circle_down_24_s
                }
            }
        }

    }

}