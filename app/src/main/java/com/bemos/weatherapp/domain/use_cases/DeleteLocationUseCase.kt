package com.bemos.weatherapp.domain.use_cases

import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.weatherapp.domain.model.Location

class DeleteLocationUseCase(
    private val repository: LocationRepository
) {

    suspend fun execute(
        location: Location
    ) {
        repository.deleteLocation(location)
    }

}