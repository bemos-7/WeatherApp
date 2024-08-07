package com.bemos.city.mappers

import com.bemos.city.models.City
import com.bemos.domain.model.city_models.CityDomain
import retrofit2.Response

class ResponseCityMapper(
    private val cityMapper: CityMapper
) {

    fun toDomainResponse(
        response: Response<City>
    ): Response<CityDomain> {
        return if (response.isSuccessful && response.body() != null) {
            val cityDomain = cityMapper.toDomain(response.body()!!)
            Response.success(cityDomain, response.raw())
        } else {
            Response.error(response.errorBody()!!, response.raw())
        }
    }

    fun toCityResponse(
        response: Response<CityDomain>
    ): Response<City> {
        return if (response.isSuccessful && response.body() != null) {
            val city = cityMapper.toCity(response.body()!!)
            Response.success(city, response.raw())
        } else {
            Response.error(response.errorBody()!!, response.raw())
        }
    }

}