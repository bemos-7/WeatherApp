package com.bemos.domain.use_cases

import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.domain.model.LocationDaoDomain
import kotlinx.coroutines.flow.Flow

class GetAllLoationsUseCase(
    private val repository: LocationRepository
) {

    fun execute() : Flow<List<com.bemos.domain.model.LocationDaoDomain>> {
        return repository.getAllLocations()
    }

}