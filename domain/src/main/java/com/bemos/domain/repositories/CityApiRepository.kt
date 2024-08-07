package com.bemos.domain.repositories

import com.bemos.domain.model.city_models.CityDomain
import retrofit2.Response

interface CityApiRepository {

    suspend fun getAllCities() : Response<com.bemos.domain.model.city_models.CityDomain>

}