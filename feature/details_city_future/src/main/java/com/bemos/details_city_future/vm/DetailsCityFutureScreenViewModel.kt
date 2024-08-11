package com.bemos.details_city_future.vm

import androidx.lifecycle.ViewModel
import com.bemos.shared.R
import com.bemos.domain.model.weather_models.AstroDomain
import com.bemos.domain.model.weather_models.ConditionDomain
import com.bemos.domain.model.weather_models.DayDomain
import com.bemos.domain.model.weather_models.ForecastdayDomain
import com.bemos.domain.model.weather_models.HourDomain
import com.bemos.feature.model.ForecastDayCF
import com.bemos.feature.model.WeatherHour
import com.bemos.domain.use_cases.IconConvertUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class DetailsCityFutureScreenViewModel(
    private val iconConvertUseCase: IconConvertUseCase
) : ViewModel() {

    val forecastDay = MutableStateFlow(
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
            R.drawable.baseline_arrow_circle_down_24_s
        )
    )

    fun covertToForecastDetailCF(
        forecastDayDomain: ForecastdayDomain
    ) {
        forecastDay.update {
            ForecastDayCF(
                forecastDayDomain = forecastDayDomain,
                weatherHour = getListWeatherHour(forecastDayDomain),
                icon = iconConvertUseCase.execute(
                    forecastDayDomain.dayDomain.conditionDomain.text
                )
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

    fun getNormalTimeIntResult(
        hourDomain: HourDomain
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