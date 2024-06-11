package com.bemos.weatherapp.domain.use_cases

import com.bemos.weatherapp.data.local.room.entity.LocationEntity
import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import kotlinx.coroutines.flow.Flow

class GetAllLoationsUseCase(
    private val repository: LocationRepository
) {

    fun execute() : Flow<List<LocationEntity>> {
        return repository.getAllLocations()
    }

}