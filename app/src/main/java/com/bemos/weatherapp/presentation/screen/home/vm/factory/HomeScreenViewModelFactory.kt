package com.bemos.weatherapp.presentation.screen.home.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.weatherapp.domain.use_cases.DeleteLocationUseCase
import com.bemos.weatherapp.domain.use_cases.GetAllCitiesUseCase
import com.bemos.weatherapp.domain.use_cases.GetAllLoationsUseCase
import com.bemos.weatherapp.domain.use_cases.InsertLocationUseCase
import com.bemos.weatherapp.presentation.screen.home.vm.HomeScreenViewModel

class HomeScreenViewModelFactory(
    val getAllLoationsUseCase: GetAllLoationsUseCase,
    val getAllCitiesUseCase: GetAllCitiesUseCase,
    val deleteLocationUseCase: DeleteLocationUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeScreenViewModel(
            getAllLocationsUseCase = getAllLoationsUseCase,
            getAllCitiesUseCase = getAllCitiesUseCase,
            deleteLocationUseCase = deleteLocationUseCase
        ) as T
    }

}