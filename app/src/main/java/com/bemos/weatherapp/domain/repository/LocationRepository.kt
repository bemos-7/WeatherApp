package com.bemos.weatherapp.data.local.room.repositoryImpl

import com.bemos.weatherapp.data.local.room.entity.LocationEntity
import com.bemos.weatherapp.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun getAllLocations() : Flow<List<Location>>

    suspend fun insertLocation(location: Location)

}