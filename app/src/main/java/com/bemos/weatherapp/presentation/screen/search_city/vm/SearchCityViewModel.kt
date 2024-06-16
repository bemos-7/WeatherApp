package com.bemos.weatherapp.presentation.screen.search_city.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.weatherapp.data.remote.retrofit.city.model.City
import com.bemos.weatherapp.domain.use_cases.GetAllCitiesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchCityViewModel(
    private val getAllCitiesUseCase: GetAllCitiesUseCase
) : ViewModel() {

    val cities = MutableStateFlow(
        City(
            listOf()
        )
    )

    suspend fun getAllCities() = viewModelScope.launch {
        val response = getAllCitiesUseCase.execute()
        if (response.isSuccessful) {
            cities.update {
                response.body()!!
            }
        }
    }

}