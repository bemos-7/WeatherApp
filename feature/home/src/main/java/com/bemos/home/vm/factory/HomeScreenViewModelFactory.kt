package com.bemos.home.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.domain.use_cases.CheckInternetUseCase
import com.bemos.domain.use_cases.DeleteLocationUseCase
import com.bemos.domain.use_cases.GetAllCitiesUseCase
import com.bemos.domain.use_cases.GetAllLoationsUseCase
import com.bemos.domain.use_cases.GetCurrentLocationUseCase
import com.bemos.domain.use_cases.GetLocationByCityUseCase
import com.bemos.home.vm.HomeScreenViewModel
import com.google.android.gms.location.FusedLocationProviderClient

class HomeScreenViewModelFactory(
    val getAllLocationsUseCase: GetAllLoationsUseCase,
    val getAllCitiesUseCase: GetAllCitiesUseCase,
    val deleteLocationUseCase: DeleteLocationUseCase,
    val getLocationByCityUseCase: GetLocationByCityUseCase,
    val checkInternetUseCase: CheckInternetUseCase,
    val getCurrentLocationUseCase: GetCurrentLocationUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeScreenViewModel(
            getAllLocationsUseCase = getAllLocationsUseCase,
            getAllCitiesUseCase = getAllCitiesUseCase,
            deleteLocationUseCase = deleteLocationUseCase,
            getLocationByCityUseCase = getLocationByCityUseCase,
            checkInternetUseCase = checkInternetUseCase,
            getCurrentLocationUseCase = getCurrentLocationUseCase
        ) as T
    }

}