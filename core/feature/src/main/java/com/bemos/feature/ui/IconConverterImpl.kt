package com.bemos.feature.ui

import com.bemos.domain.repositories.IconConverterRepository
import com.bemos.shared.R

class IconConverterImpl : IconConverterRepository {

    private val dayIcons = mapOf(
        1000 to R.drawable.sun,
        1003 to R.drawable.cloud_sun,
        1006 to R.drawable.clouds,
        1009 to R.drawable.clouds,
        1030 to R.drawable.mist_second,
        1063 to R.drawable.heavy_rain_at_times,
        1066 to R.drawable.patchy_snow_possible,
        1069 to R.drawable.patchy_sleet_possible,
        1072 to R.drawable.patchy_freezing_drizzle_possible,
        1087 to R.drawable.thundery_outbreaks_possible,
        1114 to R.drawable.blowing_snow,
        1117 to R.drawable.blizzard,
        1135 to R.drawable.fog_two,
        1147 to R.drawable.freezing_fog,
        1150 to R.drawable.patchy_light_drizzle,
        1153 to R.drawable.patchy_light_drizzle,
        1168 to R.drawable.patchy_freezing_drizzle_possible,
        1171 to R.drawable.patchy_light_drizzle,
        1180 to R.drawable.patchy_light_rain,
        1183 to R.drawable.light_rain,
        1186 to R.drawable.patchy_light_rain,
        1189 to R.drawable.light_rain,
        1192 to R.drawable.heavy_rain_at_times,
        1195 to R.drawable.heavy_rain,
        1198 to R.drawable.patchy_freezing_drizzle_possible,
        1201 to R.drawable.patchy_freezing_drizzle_possible,
        1204 to R.drawable.light_sleet,
        1207 to R.drawable.light_sleet,
        1210 to R.drawable.patchy_snow_possible,
        1213 to R.drawable.light_snow,
        1216 to R.drawable.patchy_snow_possible,
        1219 to R.drawable.light_snow,
        1222 to R.drawable.patchy_heavy_snow,
        1225 to R.drawable.heavy_snow,
        1237 to R.drawable.ice_pellets,
        1240 to R.drawable.patchy_light_rain,
        1243 to R.drawable.heavy_rain_at_times,
        1246 to R.drawable.torrential_rain_shower,
        1249 to R.drawable.patchy_sleet_possible,
        1252 to R.drawable.moderate_or_heavy_sleet_showers,
        1255 to R.drawable.patchy_snow_possible,
        1258 to R.drawable.patchy_heavy_snow,
        1261 to R.drawable.light_showers_of_ice_pellets,
        1264 to R.drawable.moderate_or_heavy_showers_of_ice_pellets,
        1273 to R.drawable.thundery_outbreaks_possible,
        1276 to R.drawable.thunder,
        1279 to R.drawable.patchy_light_snow_with_thunder,
        1282 to R.drawable.moderate_or_heavy_snow_with_thunder
    )

    private val nightIcons = mapOf(
        1000 to R.drawable.clear,
        1003 to R.drawable.night,
        1006 to R.drawable.clouds,
        1009 to R.drawable.clouds,
        1030 to R.drawable.mist_second,
        1063 to R.drawable.night_rain,
        1066 to R.drawable.patchy_snow_possible_night,
        1069 to R.drawable.patchy_sleet_possible_night,
        1072 to R.drawable.patchy_freezing_drizzle_possible,
        1087 to R.drawable.thundery_outbreaks_possible_night,
        1114 to R.drawable.blowing_snow,
        1117 to R.drawable.blizzard,
        1135 to R.drawable.fog_two,
        1147 to R.drawable.freezing_fog,
        1150 to R.drawable.patchy_light_drizzle,
        1153 to R.drawable.patchy_light_drizzle,
        1168 to R.drawable.patchy_freezing_drizzle_possible,
        1171 to R.drawable.patchy_light_drizzle,
        1180 to R.drawable.patchy_light_rain_night,
        1183 to R.drawable.light_rain,
        1186 to R.drawable.patchy_light_rain_night,
        1189 to R.drawable.light_rain,
        1192 to R.drawable.night_rain,
        1195 to R.drawable.heavy_rain,
        1198 to R.drawable.patchy_freezing_drizzle_possible,
        1201 to R.drawable.patchy_freezing_drizzle_possible,
        1204 to R.drawable.light_sleet,
        1207 to R.drawable.light_sleet,
        1210 to R.drawable.patchy_snow_possible_night,
        1213 to R.drawable.light_snow,
        1216 to R.drawable.patchy_snow_possible_night,
        1219 to R.drawable.light_snow,
        1222 to R.drawable.patchy_heavy_snow,
        1225 to R.drawable.heavy_snow,
        1237 to R.drawable.ice_pellets,
        1240 to R.drawable.patchy_light_rain_night,
        1243 to R.drawable.night_rain,
        1246 to R.drawable.torrential_rain_shower_night,
        1249 to R.drawable.patchy_sleet_possible_night,
        1252 to R.drawable.moderate_or_heavy_sleet_showers_night,
        1255 to R.drawable.patchy_snow_possible_night,
        1258 to R.drawable.patchy_heavy_snow_night,
        1261 to R.drawable.light_showers_of_ice_pellets,
        1264 to R.drawable.moderate_or_heavy_showers_of_ice_pellets_night,
        1273 to R.drawable.thundery_outbreaks_possible_night,
        1276 to R.drawable.thunder,
        1279 to R.drawable.patchy_light_snow_with_thunder_night,
        1282 to R.drawable.moderate_or_heavy_snow_with_thunder
    )

    override fun iconConvert(
        code: Int,
        time: Int
    ) : Int {
        val icons = if (time in 5..18) dayIcons else nightIcons
        return icons[code] ?: R.drawable.baseline_arrow_circle_down_24_s
    }

}