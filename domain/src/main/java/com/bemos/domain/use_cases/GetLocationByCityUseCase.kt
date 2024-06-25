package com.bemos.domain.use_cases

import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.domain.model.Location
import kotlinx.coroutines.flow.Flow

class GetLocationByCityUseCase(
    private val repository: LocationRepository
) {

    fun execute(
        city: String
    ) : Flow<Location> {
        return repository.getLocationByCity(
            city
        )
    }

}