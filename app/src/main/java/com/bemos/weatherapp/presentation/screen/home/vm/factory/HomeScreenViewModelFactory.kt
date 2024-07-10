package com.bemos.weatherapp.presentation.screen.home.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.domain.use_cases.CheckInternetUseCase
import com.bemos.domain.use_cases.DeleteLocationUseCase
import com.bemos.domain.use_cases.GetAllCitiesUseCase
import com.bemos.domain.use_cases.GetAllLoationsUseCase
import com.bemos.domain.use_cases.GetLocationByCityUseCase
import com.bemos.domain.use_cases.InsertLocationUseCase
import com.bemos.weatherapp.presentation.screen.home.vm.HomeScreenViewModel

class HomeScreenViewModelFactory(
    val getAllLocationsUseCase: GetAllLoationsUseCase,
    val getAllCitiesUseCase: GetAllCitiesUseCase,
    val deleteLocationUseCase: DeleteLocationUseCase,
    val getLocationByCityUseCase: GetLocationByCityUseCase,
    val checkInternetUseCase: CheckInternetUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeScreenViewModel(
            getAllLocationsUseCase = getAllLocationsUseCase,
            getAllCitiesUseCase = getAllCitiesUseCase,
            deleteLocationUseCase = deleteLocationUseCase,
            getLocationByCityUseCase = getLocationByCityUseCase,
            checkInternetUseCase = checkInternetUseCase
        ) as T
    }

}