package com.bemos.weatherapp.di.modules

import android.content.Context
import com.bemos.domain.use_cases.CheckInternetUseCase
import com.bemos.domain.use_cases.DeleteLocationUseCase
import com.bemos.domain.use_cases.GetAllCitiesUseCase
import com.bemos.domain.use_cases.GetAllLoationsUseCase
import com.bemos.domain.use_cases.GetLocationByCityUseCase
import com.bemos.domain.use_cases.GetLocationsByCityUseCase
import com.bemos.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.domain.use_cases.InsertLocationUseCase
import com.bemos.details_city.vm.factory.DetailsScreenViewModelFactory
import com.bemos.details_city_future.vm.factory.DetailsCityFutureScreenViewModelFactory
import com.bemos.domain.use_cases.GetCurrentLocationUseCase
import com.bemos.domain.use_cases.GetLocationSharedUseCase
import com.bemos.domain.use_cases.IconConvertUseCase
import com.bemos.domain.use_cases.SetLocationSharedUseCase
import com.bemos.settings.vm.factory.SettingsScreenViewModelFactory
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideDetailsScreenViewModelFactory(
        getWeatherAndWeekUseCase: GetWeatherAndWeekUseCase,
        insertLocationUseCase: InsertLocationUseCase,
        getLocationByCityUseCase: GetLocationsByCityUseCase,
        checkInternetUseCase: CheckInternetUseCase,
        iconConvertUseCase: IconConvertUseCase
    ) : com.bemos.details_city.vm.factory.DetailsScreenViewModelFactory {
        return com.bemos.details_city.vm.factory.DetailsScreenViewModelFactory(
            getWeatherAndWeekUseCase = getWeatherAndWeekUseCase,
            insertLocationUseCase = insertLocationUseCase,
            getLocationByCityUseCase = getLocationByCityUseCase,
            checkInternetUseCase = checkInternetUseCase,
            iconConvertUseCase = iconConvertUseCase
        )
    }

    @Provides
    fun provideHomeScreenViewModelFactory(
        getAllLocationsUseCase: GetAllLoationsUseCase,
        getAllCitiesUseCase: GetAllCitiesUseCase,
        deleteLocationUseCase: DeleteLocationUseCase,
        getLocationByCityUseCase: GetLocationByCityUseCase,
        checkInternetUseCase: CheckInternetUseCase,
        getCurrentLocationUseCase: GetCurrentLocationUseCase,
        getLocationSharedUseCase: GetLocationSharedUseCase
    ) : com.bemos.home.vm.factory.HomeScreenViewModelFactory {
        return com.bemos.home.vm.factory.HomeScreenViewModelFactory(
            getAllLocationsUseCase = getAllLocationsUseCase,
            getAllCitiesUseCase = getAllCitiesUseCase,
            deleteLocationUseCase = deleteLocationUseCase,
            getLocationByCityUseCase = getLocationByCityUseCase,
            checkInternetUseCase = checkInternetUseCase,
            getCurrentLocationUseCase = getCurrentLocationUseCase,
            getLocationSharedUseCase = getLocationSharedUseCase
        )
    }

    @Provides
    fun provideSettingsScreenViewModelFactory(
        getAllLocationsUseCase: GetAllLoationsUseCase,
        setLocationSharedUseCase: SetLocationSharedUseCase,
        getLocationSharedUseCase: GetLocationSharedUseCase
    ) : SettingsScreenViewModelFactory {
        return SettingsScreenViewModelFactory(
            getAllLocationsUseCase = getAllLocationsUseCase,
            setLocationSharedUseCase = setLocationSharedUseCase,
            getLocationSharedUseCase = getLocationSharedUseCase
        )
    }

    @Provides
    fun provideDetailsCityFutureViewModelFuture(
        iconConvertUseCase: IconConvertUseCase
    ) : DetailsCityFutureScreenViewModelFactory {
        return DetailsCityFutureScreenViewModelFactory(
            iconConvertUseCase = iconConvertUseCase
        )
    }

    @Provides
    fun provideFusedLocationProviderClient(
        context: Context
    ): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(context)
    }

}