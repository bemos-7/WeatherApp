package com.bemos.details_city_future.vm

import androidx.lifecycle.ViewModel
import com.bemos.shared.R
import com.bemos.domain.model.weather_models.AstroDomain
import com.bemos.domain.model.weather_models.ConditionDomain
import com.bemos.domain.model.weather_models.DayDomain
import com.bemos.domain.model.weather_models.ForecastdayDomain
import com.bemos.feature.model.ForecastDayCF
import com.bemos.feature.model.WeatherHour
import com.bemos.domain.use_cases.IconConvertUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class DetailsCityFutureScreenViewModel(
    private val iconConvertUseCase: IconConvertUseCase
) : ViewModel() {

    val forecastDay = MutableStateFlow<com.bemos.feature.model.ForecastDayCF>(
        com.bemos.feature.model.ForecastDayCF(
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
            R.drawable.baseline_arrow_circle_down_24_s
        )
    )

    fun covertToForecastDetailCF(
        forecastDayDomain: com.bemos.domain.model.weather_models.ForecastdayDomain
    ) {
        forecastDay.update {
            com.bemos.feature.model.ForecastDayCF(
                forecastDayDomain = forecastDayDomain,
                weatherHour = getListWeatherHour(forecastDayDomain),
                icon = iconConvertUseCase.execute(
                    forecastDayDomain.dayDomain.conditionDomain.text
                )
            )
        }
    }

    fun getListWeatherHour(
        forecastDayDomain: com.bemos.domain.model.weather_models.ForecastdayDomain
    ): List<com.bemos.feature.model.WeatherHour> {
        val weatherHour = mutableListOf<com.bemos.feature.model.WeatherHour>()

        forecastDayDomain.hourDomain.forEach {

            weatherHour.add(
                com.bemos.feature.model.WeatherHour(
                    it,
                    getNormalTime(it),
                    getNormalTimeInt(it),
                    iconConvertUseCase.execute(
                        it.conditionDomain.text,
                        getNormalTimeIntResult(it)
                    )
                )
            )
        }

        return weatherHour
    }

    fun getNormalTime(
        hourDomain: com.bemos.domain.model.weather_models.HourDomain
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
        hourDomain: com.bemos.domain.model.weather_models.HourDomain
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

    fun getNormalTimeIntResult(
        hourDomain: com.bemos.domain.model.weather_models.HourDomain
    ): Int {
        val timePattern = """(\d{2}):(\d{2})""".toRegex()
        val timePatternHalf = """(\d{1}):(\d{2})""".toRegex()

        var normalTime = timePattern.find(hourDomain.time)

        if (normalTime == null) {
            normalTime = timePatternHalf.find(hourDomain.time)
        }

        if (normalTime != null) {

            var hour = normalTime.groupValues[1]

            if (hour.toInt() <= 12) {
                return hour.toInt()
            } else {
                return hour.toInt()
            }
        }

        return -1
    }

}