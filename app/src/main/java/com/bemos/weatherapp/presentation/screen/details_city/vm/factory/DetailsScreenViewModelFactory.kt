package com.bemos.weatherapp.presentation.screen.details_city.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.weatherapp.domain.use_cases.GetWeatherUseCase
import com.bemos.weatherapp.presentation.screen.details_city.vm.DetailsScreenViewModel

class DetailsScreenViewModelFactory(
    val getWeatherUseCase: GetWeatherUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsScreenViewModel(
            getWeatherUseCase = getWeatherUseCase
        ) as T
    }

}