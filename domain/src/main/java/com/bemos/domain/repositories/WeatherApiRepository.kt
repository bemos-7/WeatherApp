package com.bemos.domain.repositories

import com.bemos.domain.model.weather_models.WeatherDomain
import retrofit2.Response
import retrofit2.http.Query

interface WeatherApiRepository {

    suspend fun getWeatherByCity(
        @Query("q") city: String,
    ) : Response<WeatherDomain>

    suspend fun getWeatherAndWeek(
        @Query("q") city: String,
    ) : Response<WeatherDomain>

}