package com.bemos.weatherapp.di.modules

import android.content.Context
import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.data.remote.retrofit.city.CityApi
import com.bemos.data.remote.retrofit.weather.WeatherApi
import com.bemos.domain.repositories.CityApiRepository
import com.bemos.domain.repositories.NetworkRepository
import com.bemos.domain.repositories.WeatherApiRepository
import com.bemos.domain.use_cases.CheckInternetUseCase
import com.bemos.domain.use_cases.DeleteLocationUseCase
import com.bemos.domain.use_cases.GetAllCitiesUseCase
import com.bemos.domain.use_cases.GetAllLoationsUseCase
import com.bemos.domain.use_cases.GetLocationByCityUseCase
import com.bemos.domain.use_cases.GetLocationsByCityUseCase
import com.bemos.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.domain.use_cases.GetWeatherUseCase
import com.bemos.domain.use_cases.InsertLocationUseCase
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
        weatherApiRepository: WeatherApiRepository
    ) : GetWeatherUseCase {
        return GetWeatherUseCase(weatherApiRepository)
    }

    @Provides
    fun provideInsertLocationUseCase(
        repository: LocationRepository
    ) : InsertLocationUseCase {
        return InsertLocationUseCase(repository)
    }

    @Provides
    fun provideGetWeatherAndWeekUseCase(
        weatherApiRepository: WeatherApiRepository
    ) : GetWeatherAndWeekUseCase {
        return GetWeatherAndWeekUseCase(
            weatherApiRepository
        )
    }

    @Provides
    fun provideGetAllCitiesUseCase(
        cityApiRepository: CityApiRepository
    ) : GetAllCitiesUseCase {
        return GetAllCitiesUseCase(
            cityApiRepository
        )
    }

    @Provides
    fun provideGetLocationByCityUseCase(
        repository: LocationRepository
    ) : GetLocationsByCityUseCase {
        return GetLocationsByCityUseCase(
            repository
        )
    }

    @Provides
    fun provideDeleteLocationUseCase(
        repository: LocationRepository
    ) : DeleteLocationUseCase {
        return DeleteLocationUseCase(
            repository
        )
    }

    @Provides
    fun getLocationByCityUseCase(
        repository: LocationRepository
    ) : GetLocationByCityUseCase {
        return GetLocationByCityUseCase(
            repository
        )
    }

    @Provides
    fun provideCheckInternetUseCase(
        networkRepository: NetworkRepository,
        context: Context
    ) : CheckInternetUseCase {
        return CheckInternetUseCase(
            networkRepository,
            context
        )
    }

}