package com.bemos.weatherapp.di.modules

import com.bemos.weatherapp.domain.use_cases.GetWeatherUseCase
import com.bemos.weatherapp.presentation.screen.details_city.vm.factory.DetailsScreenViewModelFactory
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

}