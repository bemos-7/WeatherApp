package com.bemos.weatherapp.di.modules

import com.bemos.weatherapp.domain.use_cases.GetAllLoationsUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherUseCase
import com.bemos.weatherapp.domain.use_cases.InsertLocationUseCase
import com.bemos.weatherapp.presentation.screen.details_city.vm.factory.DetailsScreenViewModelFactory
import com.bemos.weatherapp.presentation.screen.home.vm.factory.HomeScreenViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideDetailsScreenViewModelFacroty(
        getWeatherUseCase: GetWeatherUseCase
    ) : DetailsScreenViewModelFactory {
        return DetailsScreenViewModelFactory(
            getWeatherUseCase
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

}