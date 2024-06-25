package com.bemos.data.remote.retrofit.city

import com.bemos.data.remote.retrofit.city.models.City
import com.bemos.domain.model.city_models.CityDomain
import retrofit2.Response
import retrofit2.http.GET

interface CityApi {

    @GET("v0.1/countries")
    suspend fun getAllCities() : Response<City>

}