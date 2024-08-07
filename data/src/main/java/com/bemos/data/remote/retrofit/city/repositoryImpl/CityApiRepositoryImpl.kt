package com.bemos.data.remote.retrofit.city.repositoryImpl

import com.bemos.city.repository.CityApi
import com.bemos.domain.repositories.CityApiRepository
import retrofit2.Response

class CityApiRepositoryImpl(
    private val cityApi: CityApi
): CityApiRepository {
    override suspend fun getAllCities(): Response<com.bemos.domain.model.city_models.CityDomain> {
        val cityResponse = cityApi.getAllCities()

        return com.bemos.city.mappers.ResponseCityMapper(
            cityMapper = com.bemos.city.mappers.CityMapper()
        ).toDomainResponse(
            cityResponse
        )
    }

}