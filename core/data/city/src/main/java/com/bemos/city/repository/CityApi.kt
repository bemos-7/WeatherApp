package com.bemos.city.repository

import com.bemos.city.models.City
import retrofit2.Response
import retrofit2.http.GET

interface CityApi {

    @GET("v0.1/countries")
    suspend fun getAllCities() : Response<City>

}