package com.bemos.domain.use_cases

import com.bemos.domain.model.weather_models.WeatherDomain
import com.bemos.domain.repositories.WeatherApiRepository
import retrofit2.Response

class GetWeatherAndWeekUseCase(
    private val weatherApiRepository: WeatherApiRepository
) {

    suspend fun execute(
        city: String
    ) : Response<WeatherDomain> {
        return weatherApiRepository.getWeatherAndWeek(
            city = city
        )
    }

}