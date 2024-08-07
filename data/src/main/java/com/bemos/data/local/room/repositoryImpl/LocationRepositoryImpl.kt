package com.bemos.data.local.room.repositoryImpl

import com.bemos.data.local.room.dao.LocationDao
import com.bemos.data.local.room.entity.LocationEntity
import com.bemos.domain.model.LocationDaoDomain
import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocationRepositoryImpl(
    private val locationDao: LocationDao
) : LocationRepository {
    override fun getAllLocations(): Flow<List<LocationDaoDomain>> {
        return locationDao.getAllLocations()
            .map { locationEntityList ->
                locationEntityList.map { locationEntity ->
                    toDomain(locationEntity)
                }
            }
    }

    override suspend fun insertLocation(locationDaoDomain: LocationDaoDomain) {
        locationDao.insertLocation(
            location = toEntity(locationDaoDomain)
        )
    }

    override fun getLocationsByCity(city: String): Flow<List<LocationDaoDomain>> {
        return locationDao.getLocationsByCity(city)
            .map { locationEntityList ->
                locationEntityList.map { locationEntity ->
                    toDomain(locationEntity)
                }
            }
    }

    override suspend fun deleteLocation(locationDaoDomain: LocationDaoDomain) {
        locationDao.deleteLocation(
            toEntity(
                locationDaoDomain
            )
        )
    }

    override fun getLocationByCity(city: String): Flow<LocationDaoDomain> {
        return locationDao.getLocationByCity(city)
            .map { locationEntity ->
                toDomain(locationEntity)
            }
    }

    private fun toEntity(locationDaoDomain: LocationDaoDomain): LocationEntity {
        return LocationEntity(
            locationDaoDomain.id,
            locationDaoDomain.city
        )
    }

    private fun toDomain(locationEntity: LocationEntity): LocationDaoDomain {
        return LocationDaoDomain(
            locationEntity.id,
            locationEntity.city
        )
    }
}