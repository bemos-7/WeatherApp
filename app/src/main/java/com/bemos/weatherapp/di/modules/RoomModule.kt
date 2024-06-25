package com.bemos.weatherapp.di.modules

import android.content.Context
import androidx.room.Room
import com.bemos.weatherapp.data.local.room.dao.LocationDao
import com.bemos.weatherapp.data.local.room.db.LocationDatabase
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun provideLocationDatabase(
        context: Context
    ) : LocationDatabase {
        return Room.databaseBuilder(
            context = context,
            LocationDatabase::class.java,
            "db"
        ).build()
    }

    @Provides
    fun provideLocationDao(locationDatabase: LocationDatabase) : LocationDao {
        return locationDatabase.getDao()
    }

}