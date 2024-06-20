package com.bemos.weatherapp.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bemos.weatherapp.data.local.room.entity.LocationEntity
import com.bemos.weatherapp.domain.model.Location
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {

    @Query("SELECT * FROM location")
    fun getAllLocations() : Flow<List<LocationEntity>>

    @Insert
    suspend fun insertLocation(location: LocationEntity)

    @Query("SELECT * FROM location WHERE city = :city")
    fun getLocationByCity(city: String) : Flow<List<LocationEntity>>
}