package com.bemos.weatherapp.presentation.screen.detail_city_future.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bemos.domain.model.weather_models.AstroDomain
import com.bemos.domain.model.weather_models.ConditionDomain
import com.bemos.domain.model.weather_models.DayDomain
import com.bemos.domain.model.weather_models.ForecastdayDomain
import com.bemos.domain.model.weather_models.HourDomain
import com.bemos.weatherapp.presentation.screen.detail_city_future.model.ForecastDayCF
import com.bemos.weatherapp.presentation.screen.detail_city_future.model.WeatherHour
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class DetailsCityFutureScreenViewModel : ViewModel() {

    val forecastDay = MutableStateFlow<ForecastDayCF>(
        ForecastDayCF(
            ForecastdayDomain(
                AstroDomain(
                    0,
                    0,
                    0,
                    "",
                    "",
                    "",
                    "",
                    ""
                ),
                "",
                0,
                DayDomain(
                    0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    conditionDomain = ConditionDomain(
                        0,
                        "",
                        ""
                    ),
                    0,
                    0,
                    0,
                    0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                    0.0,
                ),
                listOf()
            ),
            listOf(),
        )
    )

    fun covertToForecastDetailCF(
        forecastDayDomain: ForecastdayDomain
    ) {
        forecastDay.update {
            ForecastDayCF(
                forecastDayDomain,
                getListWeatherHour(forecastDayDomain),
            )
        }
    }

    fun getListWeatherHour(
        forecastDayDomain: ForecastdayDomain
    ): List<WeatherHour> {
        val weatherHour = mutableListOf<WeatherHour>()

        forecastDayDomain.hourDomain.forEach {

            weatherHour.add(
                WeatherHour(
                    it,
                    getNormalTime(it),
                    getNormalTimeInt(it)
                )
            )
        }

        return weatherHour
    }

    fun getNormalTime(
        hourDomain: HourDomain
    ): String {
        val timePattern = """(\d{2}):(\d{2})""".toRegex()
        val timePatternHalf = """(\d{1}):(\d{2})""".toRegex()

        var normalTime = timePattern.find(hourDomain.time)

        if (normalTime == null) {
            normalTime = timePatternHalf.find(hourDomain.time)
        }

        if (normalTime != null) {

            var hour = normalTime.groupValues[1]

            if (hour.toInt() <= 12) {
                return "$hour AM"
            } else {
                return "$hour PM"
            }

        }

        return "404"
    }

    fun getNormalTimeInt(
        hourDomain: HourDomain
    ): String {
        val timePattern = """(\d{2}):(\d{2})""".toRegex()
        val timePatternHalf = """(\d{1}):(\d{2})""".toRegex()

        var normalTime = timePattern.find(hourDomain.time)

        if (normalTime == null) {
            normalTime = timePatternHalf.find(hourDomain.time)
        }

        if (normalTime != null) {

            var hour = normalTime.groupValues[1]

            if (hour.toInt() <= 12) {
                return hour
            } else {
                return hour
            }
        }

        return "405"
    }

}