package com.bemos.weatherapp.domain.use_cases

import com.bemos.weatherapp.data.remote.retrofit.WeatherApi
import com.bemos.weatherapp.data.remote.retrofit.models.Weather
import retrofit2.Response

class GetWeatherUseCase(
    private val weatherApi: WeatherApi
) {

    suspend fun execute(city: String): Response<Weather> {
        return weatherApi.getWeather(city)
    }

}