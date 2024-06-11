package com.bemos.weatherapp.data.local.room.repositoryImpl

import com.bemos.weatherapp.data.local.room.dao.LocationDao
import com.bemos.weatherapp.data.local.room.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

class LocationRepositoryImpl(
    val locationDao: LocationDao
) : LocationRepository {
    override fun getAllLocations(): Flow<List<LocationEntity>> {
        return locationDao.getAllLocations()
    }
}