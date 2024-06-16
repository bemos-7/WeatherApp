package com.bemos.weatherapp.data.remote.retrofit.city

import com.bemos.weatherapp.data.remote.retrofit.city.model.City
import retrofit2.Response
import retrofit2.http.GET

interface CityApi {

    @GET("v0.1/countries")
    suspend fun getAllCities() : Response<City>

}