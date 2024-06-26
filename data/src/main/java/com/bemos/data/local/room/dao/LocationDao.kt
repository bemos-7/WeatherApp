package com.bemos.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bemos.data.local.room.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {

    @Query("SELECT * FROM location")
    fun getAllLocations() : Flow<List<LocationEntity>>

    @Insert
    suspend fun insertLocation(location: LocationEntity)

    @Query("SELECT * FROM location WHERE city = :city")
    fun getLocationsByCity(city: String) : Flow<List<LocationEntity>>

    @Delete
    suspend fun deleteLocation(locationEntity: LocationEntity)

    @Query("SELECT * FROM location WHERE city = :city")
    fun getLocationByCity(city: String) : Flow<LocationEntity>
}