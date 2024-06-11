package com.bemos.weatherapp.data.local.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bemos.weatherapp.data.local.room.dao.LocationDao
import com.bemos.weatherapp.data.local.room.entity.LocationEntity

@Database(
    entities = [LocationEntity::class],
    version = 1
)
abstract class LocationDatabase : RoomDatabase() {

    abstract fun getDao() : LocationDao

}