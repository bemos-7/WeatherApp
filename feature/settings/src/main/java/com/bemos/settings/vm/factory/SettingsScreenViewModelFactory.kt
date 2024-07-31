package com.bemos.settings.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.domain.use_cases.GetAllLoationsUseCase
import com.bemos.settings.vm.SettingsScreenViewModel

class SettingsScreenViewModelFactory(
    private val getAllLocationsUseCase: GetAllLoationsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SettingsScreenViewModel(
            getAllLocationsUseCase = getAllLocationsUseCase
        ) as T
    }
}