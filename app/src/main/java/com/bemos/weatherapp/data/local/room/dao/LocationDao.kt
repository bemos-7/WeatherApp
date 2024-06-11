package com.bemos.weatherapp.data.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.bemos.weatherapp.data.local.room.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {

    @Query("SELECT * FROM location")
    fun getAllLocations() : Flow<List<LocationEntity>>

}