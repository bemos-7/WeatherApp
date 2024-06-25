package com.bemos.data.remote.retrofit.weather.repositoryImpl

import com.bemos.data.remote.retrofit.weather.repositoryImpl.mappers.ResponseWeatherMapper
import com.bemos.data.remote.retrofit.weather.repositoryImpl.mappers.WeatherMapper
import com.bemos.data.remote.retrofit.weather.WeatherApi
import com.bemos.domain.model.weather_models.WeatherDomain
import com.bemos.domain.repositories.WeatherApiRepository
import retrofit2.Response

class WeatherApiRepositoryImpl(
    private val weatherApi: WeatherApi
) : WeatherApiRepository {
    override suspend fun getWeatherByCity(city: String): Response<WeatherDomain> {
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
    ): Response<WeatherDomain> {
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