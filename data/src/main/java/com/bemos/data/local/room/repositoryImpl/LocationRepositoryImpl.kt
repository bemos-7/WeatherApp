package com.bemos.data.local.room.repositoryImpl

import com.bemos.data.local.room.dao.LocationDao
import com.bemos.data.local.room.entity.LocationEntity
import com.bemos.domain.model.Location
import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocationRepositoryImpl(
    private val locationDao: LocationDao
) : LocationRepository {
    override fun getAllLocations(): Flow<List<Location>> {
        return locationDao.getAllLocations()
            .map { locationEntityList ->
                locationEntityList.map { locationEntity ->
                    toDomain(locationEntity)
                }
            }
    }

    override suspend fun insertLocation(location: Location) {
        locationDao.insertLocation(
            location = toEntity(location)
        )
    }

    override fun getLocationsByCity(city: String): Flow<List<Location>> {
        return locationDao.getLocationsByCity(city)
            .map { locationEntityList ->
                locationEntityList.map { locationEntity ->
                    toDomain(locationEntity)
                }
            }
    }

    override suspend fun deleteLocation(location: Location) {
        locationDao.deleteLocation(
            toEntity(
                location
            )
        )
    }

    override fun getLocationByCity(city: String): Flow<Location> {
        return locationDao.getLocationByCity(city)
            .map { locationEntity ->
                toDomain(locationEntity)
            }
    }

    private fun toEntity(location: Location): LocationEntity {
        return LocationEntity(
            location.id,
            location.city
        )
    }

    private fun toDomain(locationEntity: LocationEntity): Location {
        return Location(
            locationEntity.id,
            locationEntity.city
        )
    }
}