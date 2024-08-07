package com.bemos.domain.use_cases

import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.domain.model.LocationDaoDomain

class InsertLocationUseCase(
    private val repository: LocationRepository
) {

    suspend fun execute(locationDaoDomain: com.bemos.domain.model.LocationDaoDomain) {
        repository.insertLocation(locationDaoDomain)
    }

}