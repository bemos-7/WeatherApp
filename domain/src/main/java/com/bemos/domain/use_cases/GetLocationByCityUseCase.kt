package com.bemos.domain.use_cases

import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.domain.model.LocationDaoDomain
import kotlinx.coroutines.flow.Flow

class GetLocationByCityUseCase(
    private val repository: LocationRepository
) {

    fun execute(
        city: String
    ) : Flow<com.bemos.domain.model.LocationDaoDomain> {
        return repository.getLocationByCity(
            city
        )
    }

}