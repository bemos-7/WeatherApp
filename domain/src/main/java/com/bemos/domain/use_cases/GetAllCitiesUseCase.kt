package com.bemos.domain.use_cases

import com.bemos.domain.model.city_models.CityDomain
import com.bemos.domain.repositories.CityApiRepository
import retrofit2.Response

class GetAllCitiesUseCase(
    private val cityApiRepository: CityApiRepository
) {

    suspend fun execute() : Response<com.bemos.domain.model.city_models.CityDomain> {
        return cityApiRepository.getAllCities()
    }

}