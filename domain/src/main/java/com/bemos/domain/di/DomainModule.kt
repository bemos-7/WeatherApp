package com.bemos.domain.di

import android.content.Context
import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.domain.repositories.CityApiRepository
import com.bemos.domain.repositories.CurrentLocationRepository
import com.bemos.domain.repositories.IconConverterRepository
import com.bemos.domain.repositories.LocationManagerRepository
import com.bemos.domain.repositories.LocationPreviewManagerRepository
import com.bemos.domain.repositories.NetworkRepository
import com.bemos.domain.repositories.WeatherApiRepository
import com.bemos.domain.use_cases.CheckInternetUseCase
import com.bemos.domain.use_cases.DeleteLocationUseCase
import com.bemos.domain.use_cases.GetAllCitiesUseCase
import com.bemos.domain.use_cases.GetAllLoationsUseCase
import com.bemos.domain.use_cases.GetBooleanSharedUseCase
import com.bemos.domain.use_cases.GetCurrentLocationUseCase
import com.bemos.domain.use_cases.GetLocationByCityUseCase
import com.bemos.domain.use_cases.GetLocationSharedUseCase
import com.bemos.domain.use_cases.GetLocationsByCityUseCase
import com.bemos.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.domain.use_cases.GetWeatherUseCase
import com.bemos.domain.use_cases.IconConvertUseCase
import com.bemos.domain.use_cases.InsertLocationUseCase
import com.bemos.domain.use_cases.SetBooleanSharedUseCase
import com.bemos.domain.use_cases.SetLocationSharedUseCase
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

    @Provides
    fun provideIconConvertUseCase(
        iconConverterRepository: IconConverterRepository
    ) : IconConvertUseCase {
        return IconConvertUseCase(
            iconConverterRepository
        )
    }

    @Provides
    fun provideGetCurrentLocationUseCase(
        currentLocationRepository: CurrentLocationRepository
    ) : GetCurrentLocationUseCase {
        return GetCurrentLocationUseCase(
            currentLocationRepository
        )
    }

    @Provides
    fun provideSetLocationSharedUseCase(
        locationManagerRepository: LocationManagerRepository
    ) : SetLocationSharedUseCase {
        return SetLocationSharedUseCase(
            locationManagerRepository
        )
    }

    @Provides
    fun provideGetLocationSharedUseCase(
        locationManagerRepository: LocationManagerRepository
    ) : GetLocationSharedUseCase {
        return GetLocationSharedUseCase(
            locationManagerRepository
        )
    }

    @Provides
    fun provideSetBooleanSharedUseCase(
        locationPreviewManagerRepository: LocationPreviewManagerRepository
    ) : SetBooleanSharedUseCase {
        return SetBooleanSharedUseCase(
            locationPreviewManagerRepository
        )
    }

    @Provides
    fun provideGetBooleanSharedUseCase(
        locationPreviewManagerRepository: LocationPreviewManagerRepository
    ) : GetBooleanSharedUseCase {
        return GetBooleanSharedUseCase(
            locationPreviewManagerRepository
        )
    }

}