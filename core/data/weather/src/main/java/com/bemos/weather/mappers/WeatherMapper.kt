package com.bemos.weather.mappers

import com.bemos.weather.models.Astro
import com.bemos.weather.models.Condition
import com.bemos.weather.models.Current
import com.bemos.weather.models.Day
import com.bemos.weather.models.Forecast
import com.bemos.weather.models.Forecastday
import com.bemos.weather.models.Hour
import com.bemos.weather.models.Location
import com.bemos.weather.models.Weather
import com.bemos.domain.model.weather_models.AstroDomain
import com.bemos.domain.model.weather_models.ConditionDomain
import com.bemos.domain.model.weather_models.CurrentDomain
import com.bemos.domain.model.weather_models.DayDomain
import com.bemos.domain.model.weather_models.ForecastDomain
import com.bemos.domain.model.weather_models.ForecastdayDomain
import com.bemos.domain.model.weather_models.HourDomain
import com.bemos.domain.model.weather_models.LocationDomain
import com.bemos.domain.model.weather_models.WeatherDomain

class WeatherMapper {

    fun toDomain(weather: Weather): com.bemos.domain.model.weather_models.WeatherDomain {
        return com.bemos.domain.model.weather_models.WeatherDomain(
            currentDomain = toDomain(weather.current),
            forecastDomain = toDomain(weather.forecast),
            locationDomain = toDomain(weather.location)
        )
    }
    
    fun toWeather(weatherDomain: com.bemos.domain.model.weather_models.WeatherDomain): Weather {
        return Weather(
            current = toWeather(weatherDomain.currentDomain),
            forecast = toWeather(weatherDomain.forecastDomain),
            location = toWeather(weatherDomain.locationDomain)
        )
    }

    private fun toDomain(current: Current) : com.bemos.domain.model.weather_models.CurrentDomain {
        return com.bemos.domain.model.weather_models.CurrentDomain(
            current.cloud,
            toDomain(current.condition),
            current.dewpoint_c,
            current.dewpoint_f,
            current.feelslike_c,
            current.feelslike_f,
            current.gust_kph,
            current.gust_mph,
            current.heatindex_c,
            current.heatindex_f,
            current.humidity,
            current.is_day,
            current.last_updated,
            current.last_updated_epoch,
            current.precip_in,
            current.precip_mm,
            current.pressure_in,
            current.pressure_mb,
            current.temp_c,
            current.temp_f,
            current.uv,
            current.vis_km,
            current.vis_miles,
            current.wind_degree,
            current.wind_dir,
            current.wind_kph,
            current.wind_mph,
            current.windchill_c,
            current.windchill_f
        )
    }

    private fun toDomain(condition: Condition) : com.bemos.domain.model.weather_models.ConditionDomain {
        return com.bemos.domain.model.weather_models.ConditionDomain(
            condition.code,
            condition.icon,
            condition.text
        )
    }

    private fun toDomain(forecast: Forecast): com.bemos.domain.model.weather_models.ForecastDomain {
        return com.bemos.domain.model.weather_models.ForecastDomain(
            forecastdayDomain = forecast.forecastday.map {
                toDomain(it)
            }
        )
    }

    private fun toDomain(forecastDay: Forecastday): com.bemos.domain.model.weather_models.ForecastdayDomain {
        return com.bemos.domain.model.weather_models.ForecastdayDomain(
            toDomain(forecastDay.astro),
            forecastDay.date,
            forecastDay.date_epoch,
            toDomain(forecastDay.day),
            forecastDay.hour.map {
                toDomain(it)
            }
        )
    }

    private fun toDomain(astro: Astro): com.bemos.domain.model.weather_models.AstroDomain {
        return com.bemos.domain.model.weather_models.AstroDomain(
            astro.is_moon_up,
            astro.is_sun_up,
            astro.moon_illumination,
            astro.moon_phase,
            astro.moonrise,
            astro.moonset,
            astro.sunrise,
            astro.sunset
        )
    }

    private fun toDomain(day: Day): com.bemos.domain.model.weather_models.DayDomain {
        return com.bemos.domain.model.weather_models.DayDomain(
            day.avghumidity,
            day.avgtemp_c,
            day.avgtemp_f,
            day.avgvis_km,
            day.avgvis_miles,
            toDomain(day.condition),
            day.daily_chance_of_rain,
            day.daily_chance_of_snow,
            day.daily_will_it_rain,
            day.daily_will_it_snow,
            day.maxtemp_c,
            day.maxtemp_f,
            day.maxwind_kph,
            day.maxwind_mph,
            day.mintemp_c,
            day.mintemp_f,
            day.totalprecip_in,
            day.totalprecip_mm,
            day.totalsnow_cm,
            day.uv
        )
    }

    private fun toDomain(hour: Hour): com.bemos.domain.model.weather_models.HourDomain {
        return com.bemos.domain.model.weather_models.HourDomain(
            hour.chance_of_rain,
            hour.chance_of_snow,
            hour.cloud,
            toDomain(hour.condition),
            hour.dewpoint_c,
            hour.dewpoint_f,
            hour.feelslike_c,
            hour.feelslike_f,
            hour.gust_kph,
            hour.gust_mph,
            hour.heatindex_c,
            hour.heatindex_f,
            hour.humidity,
            hour.is_day,
            hour.precip_in,
            hour.precip_mm,
            hour.pressure_in,
            hour.pressure_mb,
            hour.snow_cm,
            hour.temp_c,
            hour.temp_f,
            hour.time,
            hour.time_epoch,
            hour.uv,
            hour.vis_km,
            hour.vis_miles,
            hour.will_it_rain,
            hour.will_it_snow,
            hour.wind_degree,
            hour.wind_dir,
            hour.wind_kph,
            hour.wind_mph,
            hour.windchill_c,
            hour.windchill_f
        )
    }

    private fun toDomain(location: Location): com.bemos.domain.model.weather_models.LocationDomain {
        return com.bemos.domain.model.weather_models.LocationDomain(
            location.country,
            location.lat,
            location.localtime,
            location.localtime_epoch,
            location.lon,
            location.name,
            location.region,
            location.tz_id
        )
    }
    
    //------------------------------------------------------------

    private fun toWeather(currentDomain: com.bemos.domain.model.weather_models.CurrentDomain) : Current {
        return Current(
            currentDomain.cloud,
            toWeather(currentDomain.conditionDomain),
            currentDomain.dewpoint_c,
            currentDomain.dewpoint_f,
            currentDomain.feelslike_c,
            currentDomain.feelslike_f,
            currentDomain.gust_kph,
            currentDomain.gust_mph,
            currentDomain.heatindex_c,
            currentDomain.heatindex_f,
            currentDomain.humidity,
            currentDomain.is_day,
            currentDomain.last_updated,
            currentDomain.last_updated_epoch,
            currentDomain.precip_in,
            currentDomain.precip_mm,
            currentDomain.pressure_in,
            currentDomain.pressure_mb,
            currentDomain.temp_c,
            currentDomain.temp_f,
            currentDomain.uv,
            currentDomain.vis_km,
            currentDomain.vis_miles,
            currentDomain.wind_degree,
            currentDomain.wind_dir,
            currentDomain.wind_kph,
            currentDomain.wind_mph,
            currentDomain.windchill_c,
            currentDomain.windchill_f
        )
    }

    private fun toWeather(conditionDomain: com.bemos.domain.model.weather_models.ConditionDomain) : Condition {
        return Condition(
            conditionDomain.code,
            conditionDomain.icon,
            conditionDomain.text
        )
    }

    private fun toWeather(forecastDomain: com.bemos.domain.model.weather_models.ForecastDomain): Forecast {
        return Forecast(
            forecastday = forecastDomain.forecastdayDomain.map {
                toWeather(it)
            }
        )
    }

    private fun toWeather(forecastdayDomain: com.bemos.domain.model.weather_models.ForecastdayDomain): Forecastday {
        return Forecastday(
            toWeather(forecastdayDomain.astroDomain),
            forecastdayDomain.date,
            forecastdayDomain.date_epoch,
            toWeather(forecastdayDomain.dayDomain),
            forecastdayDomain.hourDomain.map {
                toWeather(it)
            }
        )
    }

    private fun toWeather(astroDomain: com.bemos.domain.model.weather_models.AstroDomain): Astro {
        return Astro(
            astroDomain.is_moon_up,
            astroDomain.is_sun_up,
            astroDomain.moon_illumination,
            astroDomain.moon_phase,
            astroDomain.moonrise,
            astroDomain.moonset,
            astroDomain.sunrise,
            astroDomain.sunset
        )
    }

    private fun toWeather(dayDomain: com.bemos.domain.model.weather_models.DayDomain): Day {
        return Day(
            dayDomain.avghumidity,
            dayDomain.avgtemp_c,
            dayDomain.avgtemp_f,
            dayDomain.avgvis_km,
            dayDomain.avgvis_miles,
            toWeather(dayDomain.conditionDomain),
            dayDomain.daily_chance_of_rain,
            dayDomain.daily_chance_of_snow,
            dayDomain.daily_will_it_rain,
            dayDomain.daily_will_it_snow,
            dayDomain.maxtemp_c,
            dayDomain.maxtemp_f,
            dayDomain.maxwind_kph,
            dayDomain.maxwind_mph,
            dayDomain.mintemp_c,
            dayDomain.mintemp_f,
            dayDomain.totalprecip_in,
            dayDomain.totalprecip_mm,
            dayDomain.totalsnow_cm,
            dayDomain.uv
        )
    }

    private fun toWeather(hourDomain: com.bemos.domain.model.weather_models.HourDomain): Hour {
        return Hour(
            hourDomain.chance_of_rain,
            hourDomain.chance_of_snow,
            hourDomain.cloud,
            toWeather(hourDomain.conditionDomain),
            hourDomain.dewpoint_c,
            hourDomain.dewpoint_f,
            hourDomain.feelslike_c,
            hourDomain.feelslike_f,
            hourDomain.gust_kph,
            hourDomain.gust_mph,
            hourDomain.heatindex_c,
            hourDomain.heatindex_f,
            hourDomain.humidity,
            hourDomain.is_day,
            hourDomain.precip_in,
            hourDomain.precip_mm,
            hourDomain.pressure_in,
            hourDomain.pressure_mb,
            hourDomain.snow_cm,
            hourDomain.temp_c,
            hourDomain.temp_f,
            hourDomain.time,
            hourDomain.time_epoch,
            hourDomain.uv,
            hourDomain.vis_km,
            hourDomain.vis_miles,
            hourDomain.will_it_rain,
            hourDomain.will_it_snow,
            hourDomain.wind_degree,
            hourDomain.wind_dir,
            hourDomain.wind_kph,
            hourDomain.wind_mph,
            hourDomain.windchill_c,
            hourDomain.windchill_f
        )
    }

    private fun toWeather(locationDomain: com.bemos.domain.model.weather_models.LocationDomain): Location {
        return Location(
            locationDomain.country,
            locationDomain.lat,
            locationDomain.localtime,
            locationDomain.localtime_epoch,
            locationDomain.lon,
            locationDomain.name,
            locationDomain.region,
            locationDomain.tz_id
        )
    }
    
}