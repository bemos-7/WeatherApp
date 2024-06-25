package com.bemos.domain.use_cases

import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.domain.model.Location
import kotlinx.coroutines.flow.Flow

class GetLocationsByCityUseCase(
    private val repository: LocationRepository
) {

    fun execute(city: String) : Flow<List<Location>> {
        return repository.getLocationsByCity(city)
    }

}