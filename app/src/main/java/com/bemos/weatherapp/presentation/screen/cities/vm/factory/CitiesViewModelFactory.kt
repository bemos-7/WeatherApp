package com.bemos.weatherapp.presentation.screen.cities.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.weatherapp.data.local.room.repositoryImpl.LocationRepository
import com.bemos.weatherapp.data.remote.retrofit.WeatherApi
import com.bemos.weatherapp.domain.use_cases.GetWeatherUseCase
import com.bemos.weatherapp.presentation.screen.cities.vm.CitiesViewModel

class CitiesViewModelFactory(
    val getWeatherUseCase: GetWeatherUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CitiesViewModel(
            getWeatherUseCase = getWeatherUseCase
        ) as T
    }

}