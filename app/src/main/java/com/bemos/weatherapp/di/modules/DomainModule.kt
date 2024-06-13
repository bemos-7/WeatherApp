package com.bemos.weatherapp.di.modules

import com.bemos.weatherapp.data.local.room.dao.LocationDao
import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.weatherapp.data.remote.retrofit.WeatherApi
import com.bemos.weatherapp.domain.use_cases.GetAllLoationsUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherUseCase
import com.bemos.weatherapp.domain.use_cases.InsertLocationUseCase
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

    @Provides
    fun provideGetWeatherUseCase(
        weatherApi: WeatherApi
    ) : GetWeatherUseCase {
        return GetWeatherUseCase(weatherApi)
    }

    @Provides
    fun provideInsertLocationUseCase(
        repository: LocationRepository
    ) : InsertLocationUseCase {
        return InsertLocationUseCase(repository)
    }

    @Provides
    fun provideGetWeatherAndWeekUseCase(
        weatherApi: WeatherApi
    ) : GetWeatherAndWeekUseCase {
        return GetWeatherAndWeekUseCase(
            weatherApi
        )
    }

}