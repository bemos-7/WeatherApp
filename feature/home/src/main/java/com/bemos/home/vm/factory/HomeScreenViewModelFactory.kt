package com.bemos.home.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.domain.use_cases.CheckInternetUseCase
import com.bemos.domain.use_cases.DeleteLocationUseCase
import com.bemos.domain.use_cases.GetAllCitiesUseCase
import com.bemos.domain.use_cases.GetAllLoationsUseCase
import com.bemos.domain.use_cases.GetBooleanSharedUseCase
import com.bemos.domain.use_cases.GetCurrentLocationUseCase
import com.bemos.domain.use_cases.GetLocationByCityUseCase
import com.bemos.domain.use_cases.GetLocationSharedUseCase
import com.bemos.domain.use_cases.GetWeatherAndWeekUseCase
import com.bemos.domain.use_cases.GetWeatherUseCase
import com.bemos.home.vm.HomeScreenViewModel
import com.google.android.gms.location.FusedLocationProviderClient

class HomeScreenViewModelFactory(
    private val getAllLocationsUseCase: GetAllLoationsUseCase,
    private val getAllCitiesUseCase: GetAllCitiesUseCase,
    private val deleteLocationUseCase: DeleteLocationUseCase,
    private val getLocationByCityUseCase: GetLocationByCityUseCase,
    private val checkInternetUseCase: CheckInternetUseCase,
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase,
    private val getLocationSharedUseCase: GetLocationSharedUseCase,
    private val getBooleanSharedUseCase: GetBooleanSharedUseCase,
    private val getWeatherAndWeekUseCase: GetWeatherAndWeekUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeScreenViewModel(
            getAllLocationsUseCase = getAllLocationsUseCase,
            getAllCitiesUseCase = getAllCitiesUseCase,
            deleteLocationUseCase = deleteLocationUseCase,
            getLocationByCityUseCase = getLocationByCityUseCase,
            checkInternetUseCase = checkInternetUseCase,
            getCurrentLocationUseCase = getCurrentLocationUseCase,
            getLocationSharedUseCase = getLocationSharedUseCase,
            getBooleanSharedUseCase = getBooleanSharedUseCase,
            getWeatherAndWeekUseCase = getWeatherAndWeekUseCase
        ) as T
    }

}