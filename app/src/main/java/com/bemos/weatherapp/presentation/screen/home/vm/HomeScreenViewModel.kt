package com.bemos.weatherapp.presentation.screen.home.vm

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.weatherapp.domain.model.Location
import com.bemos.weatherapp.domain.use_cases.DeleteLocationUseCase
import com.bemos.weatherapp.domain.use_cases.GetAllCitiesUseCase
import com.bemos.weatherapp.domain.use_cases.GetAllLoationsUseCase
import com.bemos.weatherapp.domain.use_cases.InsertLocationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getAllLocationsUseCase: GetAllLoationsUseCase,
    private val getAllCitiesUseCase: GetAllCitiesUseCase,
    private val deleteLocationUseCase: DeleteLocationUseCase
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

    val isTrue = MutableStateFlow(false)

    val city = MutableStateFlow("")

    fun getAllLocations() = viewModelScope.launch {
        getAllLocationsUseCase.execute()
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

    suspend fun deleteLocation(
        city: String
    ) = viewModelScope.launch {

        deleteLocationUseCase.execute(
            Location(
                city = city
            )
        )
    }

    @Composable
    fun OpenDeleteDialog(
        city: String,
        isTrueValue: Boolean
    ) {
        if (isTrueValue) {
            AlertDialog(
                onDismissRequest = {
                    isTrue.update {
                        false
                    }
                },
                title = { Text(text = "Подтверждения действия") },
                text = { Text(text = "Вы действительно хотите удалить выбранный элемент") },
                confirmButton = {
                    TextButton(onClick = {
                        isTrue.update {
                            false
                        }
                        viewModelScope.launch {
                            deleteLocationUseCase.execute(
                                Location(
                                    city = city
                                )
                            )
                        }
                    }
                    ) {
                        Text(text = "Удалить")
                    }
                }
            )
        }
    }

    fun updateIsTrueAndCity(
        isTrueValue: Boolean,
        cityValue: String
    ) {
        isTrue.update {
            isTrueValue
        }
        city.update {
            cityValue
        }
    }
}