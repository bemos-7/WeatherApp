package com.bemos.weather.repository

import com.bemos.shared.Constants.API_KEY
import com.bemos.weather.models.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/current.json?")
    suspend fun getWeatherByCity(
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no",
    ) : Response<Weather>

    @GET("v1/forecast.json?")
    suspend fun getWeatherAndWeek(
        @Query("q") city: String,
        @Query("days") days: String = "10",
        @Query("api") api: String = "no",
        @Query("alerts") alerts: String = "no",
    ) : Response<Weather>
}

// 91c262dcdf7b401686e200400241106
// d7de071820f14654baf182452242806