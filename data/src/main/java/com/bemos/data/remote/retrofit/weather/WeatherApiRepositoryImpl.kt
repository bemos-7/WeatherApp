package com.bemos.data.remote.retrofit.weather

import com.bemos.weather.mappers.ResponseWeatherMapper
import com.bemos.weather.mappers.WeatherMapper
import com.bemos.weather.repository.WeatherApi
import com.bemos.domain.repositories.WeatherApiRepository
import retrofit2.Response

class WeatherApiRepositoryImpl(
    private val weatherApi: WeatherApi
) : WeatherApiRepository {
    override suspend fun getWeatherByCity(city: String): Response<com.bemos.domain.model.weather_models.WeatherDomain> {
        val weatherResponse = weatherApi.getWeatherByCity(
            city
        )

        return ResponseWeatherMapper(
            weatherMapper = WeatherMapper()
        ).toDomainResponse(
            weatherResponse
        )
    }

    override suspend fun getWeatherAndWeek(
        city: String,
    ): Response<com.bemos.domain.model.weather_models.WeatherDomain> {
        val weatherResponse = weatherApi.getWeatherAndWeek(
            city
        )

        return ResponseWeatherMapper(
            weatherMapper = WeatherMapper()
        ).toDomainResponse(
            weatherResponse
        )
    }


}