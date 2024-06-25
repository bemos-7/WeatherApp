package com.bemos.domain.use_cases

import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.domain.model.Location

class InsertLocationUseCase(
    private val repository: LocationRepository
) {

    suspend fun execute(location: Location) {
        repository.insertLocation(location)
    }

}