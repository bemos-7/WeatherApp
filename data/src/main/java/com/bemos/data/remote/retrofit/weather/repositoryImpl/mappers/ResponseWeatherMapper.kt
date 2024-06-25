package com.bemos.data.remote.retrofit.weather.repositoryImpl.mappers

import com.bemos.data.remote.retrofit.weather.models.Weather
import com.bemos.domain.model.weather_models.WeatherDomain
import retrofit2.Response

class ResponseWeatherMapper(
    private val weatherMapper: WeatherMapper
) {

    fun toDomainResponse(
        response: Response<Weather>
    ): Response<WeatherDomain> {
        return if (response.isSuccessful && response.body() != null) {
            val weatherDomain = weatherMapper.toDomain(response.body()!!)
            Response.success(weatherDomain, response.raw())
        } else {
            Response.error(response.errorBody()!!, response.raw())
        }
    }

    fun toWeatherResponse(
        response: Response<WeatherDomain>
    ): Response<Weather> {
        return if (response.isSuccessful && response.body() != null) {
            val weather = weatherMapper.toWeather(response.body()!!)
            Response.success(weather, response.raw())
        } else {
            Response.error(response.errorBody()!!, response.raw())
        }
    }

}