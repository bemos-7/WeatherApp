package com.bemos.weatherapp.di.modules

import com.bemos.weatherapp.data.remote.retrofit.WeatherApi
import com.bemos.weatherapp.domain.use_cases.GetWeatherUseCase
import com.bemos.weatherapp.presentation.screen.cities.vm.factory.CitiesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideCitiesViewModelFactory(
        getWeatherUseCase: GetWeatherUseCase
    ) : CitiesViewModelFactory {
        return CitiesViewModelFactory(
            getWeatherUseCase
        )
    }

}