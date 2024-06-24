package com.bemos.weatherapp.di.modules

import com.bemos.weatherapp.domain.use_cases.DeleteLocationUseCase
import com.bemos.weatherapp.domain.use_cases.GetAllCitiesUseCase
import com.bemos.weatherapp.domain.use_cases.GetAllLoationsUseCase
import com.bemos.weatherapp.domain.use_cases.GetLocationByCityUseCase
import com.bemos.weatherapp.domain.use_cases.GetLocationsByCityUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.weatherapp.domain.use_cases.InsertLocationUseCase
import com.bemos.weatherapp.presentation.screen.details_city.vm.factory.DetailsScreenViewModelFactory
import com.bemos.weatherapp.presentation.screen.home.vm.factory.HomeScreenViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideDetailsScreenViewModelFactory(
        getWeatherAndWeekUseCase: GetWeatherAndWeekUseCase,
        insertLocationUseCase: InsertLocationUseCase,
        getLocationByCityUseCase: GetLocationsByCityUseCase
    ) : DetailsScreenViewModelFactory {
        return DetailsScreenViewModelFactory(
            getWeatherAndWeekUseCase = getWeatherAndWeekUseCase,
            insertLocationUseCase = insertLocationUseCase,
            getLocationByCityUseCase = getLocationByCityUseCase
        )
    }

    @Provides
    fun provideHomeScreenViewModelFactory(
        getAllLocationsUseCase: GetAllLoationsUseCase,
        getAllCitiesUseCase: GetAllCitiesUseCase,
        deleteLocationUseCase: DeleteLocationUseCase,
        getLocationByCityUseCase: GetLocationByCityUseCase
    ) : HomeScreenViewModelFactory {
        return HomeScreenViewModelFactory(
            getAllLocationsUseCase = getAllLocationsUseCase,
            getAllCitiesUseCase = getAllCitiesUseCase,
            deleteLocationUseCase = deleteLocationUseCase,
            getLocationByCityUseCase = getLocationByCityUseCase
        )
    }

}