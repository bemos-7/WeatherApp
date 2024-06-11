package com.bemos.weatherapp.di.modules

import com.bemos.weatherapp.data.local.room.dao.LocationDao
import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.weatherapp.domain.use_cases.GetAllLoationsUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetAllLocationsUseCase(
        repository: LocationRepository
    ) : GetAllLoationsUseCase {
        return GetAllLoationsUseCase(repository)
    }
}