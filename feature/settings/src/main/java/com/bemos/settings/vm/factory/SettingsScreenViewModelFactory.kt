package com.bemos.settings.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.domain.use_cases.GetAllLoationsUseCase
import com.bemos.domain.use_cases.GetLocationSharedUseCase
import com.bemos.domain.use_cases.SetLocationSharedUseCase
import com.bemos.settings.vm.SettingsScreenViewModel

class SettingsScreenViewModelFactory(
    private val getAllLocationsUseCase: GetAllLoationsUseCase,
    private val setLocationSharedUseCase: SetLocationSharedUseCase,
    private val getLocationSharedUseCase: GetLocationSharedUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SettingsScreenViewModel(
            getAllLocationsUseCase = getAllLocationsUseCase,
            setLocationSharedUseCase = setLocationSharedUseCase,
            getLocationSharedUseCase = getLocationSharedUseCase
        ) as T
    }
}