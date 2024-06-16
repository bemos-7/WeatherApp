package com.bemos.weatherapp.di.modules

import com.bemos.weatherapp.domain.use_cases.GetAllCitiesUseCase
import com.bemos.weatherapp.domain.use_cases.GetAllLoationsUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherUseCase
import com.bemos.weatherapp.domain.use_cases.InsertLocationUseCase
import com.bemos.weatherapp.presentation.screen.details_city.vm.factory.DetailsScreenViewModelFactory
import com.bemos.weatherapp.presentation.screen.home.vm.factory.HomeScreenViewModelFactory
import com.bemos.weatherapp.presentation.screen.search_city.vm.factory.SearchCityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideDetailsScreenViewModelFacroty(
        getWeatherUseCase: GetWeatherUseCase,
        getWeatherAndWeekUseCase: GetWeatherAndWeekUseCase
    ) : DetailsScreenViewModelFactory {
        return DetailsScreenViewModelFactory(
            getWeatherUseCase = getWeatherUseCase,
            getWeatherAndWeekUseCase = getWeatherAndWeekUseCase
        )
    }

    @Provides
    fun provideHomeScreenViewModelFactory(
        getAllLoationsUseCase: GetAllLoationsUseCase,
        insertLocationUseCase: InsertLocationUseCase
    ) : HomeScreenViewModelFactory {
        return HomeScreenViewModelFactory(
            getAllLoationsUseCase = getAllLoationsUseCase,
            insertLocationUseCase = insertLocationUseCase
        )
    }

    @Provides
    fun provideSearchCityViewModelFactory(
        getAllCitiesUseCase: GetAllCitiesUseCase
    ) : SearchCityViewModelFactory {
        return SearchCityViewModelFactory(
            getAllCitiesUseCase = getAllCitiesUseCase
        )
    }

}