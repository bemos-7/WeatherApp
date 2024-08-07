package com.bemos.weatherapp.data.local.room.repositoryImpl

import com.bemos.domain.model.LocationDaoDomain
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun getAllLocations() : Flow<List<com.bemos.domain.model.LocationDaoDomain>>

    suspend fun insertLocation(locationDaoDomain: com.bemos.domain.model.LocationDaoDomain)

    fun getLocationsByCity(city: String) : Flow<List<com.bemos.domain.model.LocationDaoDomain>>

    suspend fun deleteLocation(locationDaoDomain: com.bemos.domain.model.LocationDaoDomain)

    fun getLocationByCity(city: String) : Flow<com.bemos.domain.model.LocationDaoDomain>

}