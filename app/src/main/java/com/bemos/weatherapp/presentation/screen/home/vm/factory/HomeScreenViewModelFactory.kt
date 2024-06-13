package com.bemos.weatherapp.presentation.screen.home.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.weatherapp.domain.use_cases.GetAllLoationsUseCase
import com.bemos.weatherapp.domain.use_cases.InsertLocationUseCase
import com.bemos.weatherapp.presentation.screen.home.vm.HomeScreenViewModel

class HomeScreenViewModelFactory(
    val getAllLoationsUseCase: GetAllLoationsUseCase,
    val insertLocationUseCase: InsertLocationUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeScreenViewModel(
            getAllLoationsUseCase = getAllLoationsUseCase,
            insertLocationUseCase = insertLocationUseCase
        ) as T
    }

}