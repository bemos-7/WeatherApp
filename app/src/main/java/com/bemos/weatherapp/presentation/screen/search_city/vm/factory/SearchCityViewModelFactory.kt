package com.bemos.weatherapp.presentation.screen.search_city.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.weatherapp.domain.use_cases.GetAllCitiesUseCase
import com.bemos.weatherapp.presentation.screen.search_city.vm.SearchCityViewModel

class SearchCityViewModelFactory(
    val getAllCitiesUseCase: GetAllCitiesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchCityViewModel(
            getAllCitiesUseCase = getAllCitiesUseCase
        ) as T
    }

}