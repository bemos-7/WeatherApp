package com.bemos.weatherapp.di.modules

import com.bemos.weatherapp.data.local.room.dao.LocationDao
import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideLocationRepository(locationDao: LocationDao) : LocationRepository {
        return LocationRepositoryImpl(locationDao)
    }

}