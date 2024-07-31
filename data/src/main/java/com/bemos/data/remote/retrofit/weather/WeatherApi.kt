package com.bemos.data.remote.retrofit.weather

import com.bemos.data.remote.retrofit.weather.models.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/current.json?")
    suspend fun getWeatherByCity(
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no",
        @Query("key") apiKey: String = API_KEY
    ) : Response<Weather>

    @GET("v1/forecast.json?")
    suspend fun getWeatherAndWeek(
        @Query("q") city: String,
        @Query("days") days: String = "10",
        @Query("api") api: String = "no",
        @Query("alerts") alerts: String = "no",
        @Query("key") apiKey: String = API_KEY
    ) : Response<Weather>

    companion object {
        private const val API_KEY = "b6f4aefd431a408a9ad173212241307"
    }
}

// 91c262dcdf7b401686e200400241106
// d7de071820f14654baf182452242806