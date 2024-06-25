package com.bemos.domain.use_cases

import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.domain.model.Location
import kotlinx.coroutines.flow.Flow

class GetAllLoationsUseCase(
    private val repository: LocationRepository
) {

    fun execute() : Flow<List<Location>> {
        return repository.getAllLocations()
    }

}