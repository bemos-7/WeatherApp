package com.bemos.data.di

import android.content.Context
import com.bemos.data.local.room.dao.LocationDao
import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.data.local.room.repositoryImpl.LocationRepositoryImpl
import com.bemos.data.remote.retrofit.city.CityApi
import com.bemos.data.remote.retrofit.city.repositoryImpl.CityApiRepositoryImpl
import com.bemos.data.remote.retrofit.weather.WeatherApi
import com.bemos.data.remote.retrofit.weather.repositoryImpl.WeatherApiRepositoryImpl
import com.bemos.domain.repositories.CityApiRepository
import com.bemos.domain.repositories.LocationManagerRepository
import com.bemos.domain.repositories.WeatherApiRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class DataModule {

    @Provides
    fun provideLocationRepository(locationDao: LocationDao) : LocationRepository {
        return LocationRepositoryImpl(locationDao)
    }

    @Provides
    fun provideWeatherApiRepository(weatherApi: WeatherApi) : WeatherApiRepository {
        return WeatherApiRepositoryImpl(weatherApi)
    }

    @Provides
    fun provideCityApiRepository(@Named("City") cityApi: CityApi) : CityApiRepository {
        return CityApiRepositoryImpl(cityApi)
    }

}