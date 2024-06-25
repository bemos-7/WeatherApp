package com.bemos.weatherapp.domain.use_cases

import com.bemos.weatherapp.data.remote.retrofit.city.CityApi
import com.bemos.weatherapp.data.remote.retrofit.city.model.City
import retrofit2.Response

class GetAllCitiesUseCase(
    private val cityApi: CityApi
) {

    suspend fun execute() : Response<City> {
        return cityApi.getAllCities()
    }

}