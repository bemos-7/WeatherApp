package com.bemos.weatherapp.domain.use_cases

import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.weatherapp.domain.model.Location
import kotlinx.coroutines.flow.Flow

class GetLocationByCityUseCase(
    private val repository: LocationRepository
) {

    suspend fun execute(city: String) : Flow<List<Location>> {
        return repository.getLocationByCity(city)
    }

}