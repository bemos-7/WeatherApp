package com.bemos.details_city_future.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.details_city_future.vm.DetailsCityFutureScreenViewModel
import com.bemos.domain.use_cases.IconConvertUseCase

class DetailsCityFutureScreenViewModelFactory(
    val iconConvertUseCase: IconConvertUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsCityFutureScreenViewModel(
            iconConvertUseCase
        ) as T
    }
}