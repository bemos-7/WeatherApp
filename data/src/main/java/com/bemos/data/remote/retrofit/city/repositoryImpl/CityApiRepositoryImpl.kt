package com.bemos.data.remote.retrofit.city.repositoryImpl

import com.bemos.data.remote.retrofit.city.CityApi
import com.bemos.data.remote.retrofit.city.mappers.CityMapper
import com.bemos.data.remote.retrofit.city.mappers.ResponseCityMapper
import com.bemos.domain.model.city_models.CityDomain
import com.bemos.domain.repositories.CityApiRepository
import retrofit2.Response

class CityApiRepositoryImpl(
    private val cityApi: CityApi
): CityApiRepository {
    override suspend fun getAllCities(): Response<CityDomain> {
        val cityResponse = cityApi.getAllCities()

        return ResponseCityMapper(
            cityMapper = CityMapper()
        ).toDomainResponse(
            cityResponse
        )
    }

}