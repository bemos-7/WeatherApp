package com.bemos.data.di

import android.content.Context
import com.bemos.city.repository.CityApi
import com.bemos.core.Constants.ANNOTATION_NAME_CITY
import com.bemos.data.local.room.dao.LocationDao
import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.data.local.room.repositoryImpl.LocationRepositoryImpl
import com.bemos.data.local.shared_preferences.repository_impl.LocationManagerRepositoryImpl
import com.bemos.data.local.shared_preferences.repository_impl.LocationPreviewManagerRepositoryImpl
import com.bemos.data.remote.retrofit.city.repositoryImpl.CityApiRepositoryImpl
import com.bemos.weather.repository.WeatherApi
import com.bemos.data.remote.retrofit.weather.WeatherApiRepositoryImpl
import com.bemos.domain.repositories.CityApiRepository
import com.bemos.city.shared_preferences_repo.LocationManagerRepository
import com.bemos.city.shared_preferences_repo.LocationPreviewManagerRepository
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
    fun provideCityApiRepository(@Named(ANNOTATION_NAME_CITY) cityApi: CityApi) : CityApiRepository {
        return CityApiRepositoryImpl(cityApi)
    }

    @Provides
    fun provideLocationManagerRepository(context: Context): LocationManagerRepository {
        return LocationManagerRepositoryImpl(context)
    }

    @Provides
    fun  provideLocationPreviewManagerRepository(context: Context): LocationPreviewManagerRepository {
        return LocationPreviewManagerRepositoryImpl(context)
    }

}