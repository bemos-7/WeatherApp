package com.bemos.weatherapp.presentation.screen.home.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.weatherapp.domain.model.Location
import com.bemos.weatherapp.domain.use_cases.GetAllCitiesUseCase
import com.bemos.weatherapp.domain.use_cases.GetAllLoationsUseCase
import com.bemos.weatherapp.domain.use_cases.InsertLocationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getAllLoationsUseCase: GetAllLoationsUseCase,
    private val insertLocationUseCase: InsertLocationUseCase,
    private val getAllCitiesUseCase: GetAllCitiesUseCase
) : ViewModel() {

    val locations = MutableStateFlow<List<Location>>(
        emptyList()
    )

    val cities = MutableStateFlow<List<String>>(
        listOf()
    )

    val searchCities = MutableStateFlow<List<String>>(
        listOf()
    )

    fun getAllLocations() = viewModelScope.launch {
        getAllLoationsUseCase.execute()
            .collect { listLocation ->
                locations.update {
                    listLocation
                }
            }
    }

    suspend fun getAllCities() = viewModelScope.launch {
        val response = getAllCitiesUseCase.execute()

        var cityList = mutableListOf<String>()

        if (response.isSuccessful) {
            response.body()!!.data.forEach { data ->
                data.cities.forEach {
                    cityList.add(it)
                }
            }
            cities.update {
                cityList
            }
        }
    }

    fun searchCity(city: String) {
        if (city.isNotEmpty()) {
            val cityNameList = cities.value

            searchCities.update {
                cityNameList.filter {
                    it.lowercase().startsWith(city.lowercase())
                }
            }
        } else {
            searchCities.update {
                cities.value
            }
        }
    }


}