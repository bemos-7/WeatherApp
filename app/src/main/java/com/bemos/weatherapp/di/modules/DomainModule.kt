package com.bemos.weatherapp.di.modules

import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.weatherapp.data.remote.retrofit.city.CityApi
import com.bemos.weatherapp.data.remote.retrofit.weather.WeatherApi
import com.bemos.weatherapp.domain.use_cases.GetAllCitiesUseCase
import com.bemos.weatherapp.domain.use_cases.GetAllLoationsUseCase
import com.bemos.weatherapp.domain.use_cases.GetLocationByCityUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherUseCase
import com.bemos.weatherapp.domain.use_cases.InsertLocationUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Named

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

    @Provides
    fun provideGetAllCitiesUseCase(
        @Named("City") cityApi: CityApi
    ) : GetAllCitiesUseCase {
        return GetAllCitiesUseCase(
            cityApi
        )
    }

    @Provides
    fun provideGetLocationByCityUseCase(
        repository: LocationRepository
    ) : GetLocationByCityUseCase {
        return GetLocationByCityUseCase(
            repository
        )
    }

}