package com.bemos.weatherapp.presentation.screen.details_city.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.weatherapp.domain.use_cases.GetLocationByCityUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.weatherapp.domain.use_cases.GetWeatherUseCase
import com.bemos.weatherapp.domain.use_cases.InsertLocationUseCase
import com.bemos.weatherapp.presentation.screen.details_city.vm.DetailsScreenViewModel

class DetailsScreenViewModelFactory(
    val getWeatherAndWeekUseCase: GetWeatherAndWeekUseCase,
    val insertLocationUseCase: InsertLocationUseCase,
    val getLocationByCityUseCase: GetLocationByCityUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsScreenViewModel(
            getWeatherAndWeekUseCase = getWeatherAndWeekUseCase,
            insertLocationUseCase = insertLocationUseCase,
            getLocationByCityUseCase = getLocationByCityUseCase
        ) as T
    }

}