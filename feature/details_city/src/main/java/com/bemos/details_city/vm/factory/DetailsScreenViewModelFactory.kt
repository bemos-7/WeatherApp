package com.bemos.details_city.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.domain.use_cases.CheckInternetUseCase
import com.bemos.domain.use_cases.GetLocationsByCityUseCase
import com.bemos.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.domain.use_cases.InsertLocationUseCase
import com.bemos.details_city.vm.DetailsScreenViewModel
import com.bemos.domain.use_cases.IconConvertUseCase

class DetailsScreenViewModelFactory(
    val getWeatherAndWeekUseCase: GetWeatherAndWeekUseCase,
    val insertLocationUseCase: InsertLocationUseCase,
    val getLocationByCityUseCase: GetLocationsByCityUseCase,
    val checkInternetUseCase: CheckInternetUseCase,
    val iconConvertUseCase: IconConvertUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsScreenViewModel(
            getWeatherAndWeekUseCase = getWeatherAndWeekUseCase,
            insertLocationUseCase = insertLocationUseCase,
            getLocationByCityUseCase = getLocationByCityUseCase,
            checkInternetUseCase = checkInternetUseCase,
            iconConvertUseCase = iconConvertUseCase
        ) as T
    }

}