package com.bemos.weatherapp.data.local.room.repositoryImpl

import com.bemos.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun getAllLocations() : Flow<List<Location>>

    suspend fun insertLocation(location: Location)

    fun getLocationsByCity(city: String) : Flow<List<Location>>

    suspend fun deleteLocation(location: Location)

    fun getLocationByCity(city: String) : Flow<Location>

}