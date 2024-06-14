package com.bemos.weatherapp.data.remote.retrofit

import com.bemos.weatherapp.data.remote.retrofit.models.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/current.json?key=$API_KEY")
    suspend fun getWeatherByCity(
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no",
    ) : Response<Weather>

    @GET("v1/forecast.json?key=$API_KEY")
    suspend fun getWeatherAndWeek(
        @Query("q") city: String,
        @Query("days") days: String = "10",
        @Query("api") api: String = "no",
        @Query("alerts") alerts: String = "no"
    ) : Response<Weather>

    companion object {
        const val API_KEY = "91c262dcdf7b401686e200400241106"
    }
}