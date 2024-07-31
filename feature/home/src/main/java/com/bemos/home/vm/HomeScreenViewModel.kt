package com.bemos.home.vm

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.domain.model.Location
import com.bemos.domain.use_cases.CheckInternetUseCase
import com.bemos.domain.use_cases.DeleteLocationUseCase
import com.bemos.domain.use_cases.GetAllCitiesUseCase
import com.bemos.domain.use_cases.GetAllLoationsUseCase
import com.bemos.domain.use_cases.GetCurrentLocationUseCase
import com.bemos.domain.use_cases.GetLocationByCityUseCase
import com.bemos.domain.use_cases.IconConvertUseCase
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getAllLocationsUseCase: GetAllLoationsUseCase,
    private val getAllCitiesUseCase: GetAllCitiesUseCase,
    private val deleteLocationUseCase: DeleteLocationUseCase,
    private val getLocationByCityUseCase: GetLocationByCityUseCase,
    private val checkInternetUseCase: CheckInternetUseCase,
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase
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

    val locationToDelete = MutableStateFlow(
        Location(
            city = ""
        )
    )

    val isTrue = MutableStateFlow(false)

    val networkState = MutableStateFlow(true)

    val locationDelete = MutableStateFlow(
        Location(
            city = ""
        )
    )

    fun getAllLocations() = viewModelScope.launch {
        getAllLocationsUseCase.execute()
            .collect { listLocation ->
                locations.update {
                    listLocation
                }
            }
    }

    suspend fun getAllCities() = viewModelScope.launch {
        if (networkState.value) {
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
        } else {
            networkState.update {
                false
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
        location: Location
    ) = viewModelScope.launch {
        deleteLocationUseCase.execute(
            location
        )
    }

    fun deleteLocationScope(
        location: Location
    ) = viewModelScope.launch {
        deleteLocation(
            location
        )
    }

    suspend fun getLocationByCity(
        city: String
    ) = viewModelScope.launch {
        getLocationByCityUseCase.execute(
            city
        ).collect { locationItem ->
            locationToDelete.update {
                locationItem
            }
        }
    }

    fun checkInternet() {
        networkState.update {
            checkInternetUseCase.execute()
        }
    }

    fun getLocationByCityScope(
        city: String
    ) {
        viewModelScope.launch {
            getLocationByCity(
                city
            )
        }
    }

    fun updateIsTrue(
        isTrueValue: Boolean
    ) {
        isTrue.update {
            isTrueValue
        }
    }

    fun updateIsTrueAndLocation(
        isTrueValue: Boolean,
        location: Location
    ) {
        isTrue.update {
            isTrueValue
        }
        locationDelete.update {
            location
        }
    }

    fun getCurrentLocation(
        location: (String) -> Unit
    ) {
        getCurrentLocationUseCase.execute {
            if (it != null) {
                location(it)
            }
        }
    }
}