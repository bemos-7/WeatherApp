package com.bemos.weatherapp.data.local.room.repositoryImpl

import com.bemos.weatherapp.data.local.room.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun getAllLocations() : Flow<List<LocationEntity>>

}