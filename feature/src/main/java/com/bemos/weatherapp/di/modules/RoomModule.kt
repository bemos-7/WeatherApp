package com.bemos.weatherapp.di.modules

import android.content.Context
import androidx.room.Room
import com.bemos.data.local.room.dao.LocationDao
import com.bemos.data.local.room.db.LocationDatabase
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun provideLocationDatabase(
        context: Context
    ) : com.bemos.data.local.room.db.LocationDatabase {
        return Room.databaseBuilder(
            context = context,
            com.bemos.data.local.room.db.LocationDatabase::class.java,
            "db"
        ).build()
    }

    @Provides
    fun provideLocationDao(locationDatabase: com.bemos.data.local.room.db.LocationDatabase) : com.bemos.data.local.room.dao.LocationDao {
        return locationDatabase.getDao()
    }

}