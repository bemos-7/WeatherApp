package com.bemos.home.vm

import android.location.Location
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bemos.domain.model.LocationDaoDomain
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
import com.bemos.feature.model.LocationWithWeather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getAllLocationsUseCase: GetAllLoationsUseCase,
    private val getAllCitiesUseCase: GetAllCitiesUseCase,
    private val deleteLocationUseCase: DeleteLocationUseCase,
    private val getLocationByCityUseCase: GetLocationByCityUseCase,
    private val checkInternetUseCase: CheckInternetUseCase,
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase,
    private val getLocationSharedUseCase: GetLocationSharedUseCase,
    private val getBooleanSharedUseCase: GetBooleanSharedUseCase,
    private val getWeatherAndWeekUseCase: GetWeatherAndWeekUseCase
) : ViewModel() {

    val locations = MutableStateFlow<List<LocationDaoDomain>>(
        emptyList()
    )

    val locationsWithWeather = MutableStateFlow<List<LocationWithWeather>>(
        emptyList()
    )

    val cities = MutableStateFlow<List<String>>(
        listOf()
    )

    val searchCities = MutableStateFlow<List<String>>(
        listOf()
    )

    val locationDaoDomainToDelete = MutableStateFlow(
        com.bemos.domain.model.LocationDaoDomain(
            city = ""
        )
    )

    val isTrue = MutableStateFlow(false)

    val networkState = MutableStateFlow(true)

    val locationDaoDomainDelete = MutableStateFlow(
        com.bemos.domain.model.LocationDaoDomain(
            city = ""
        )
    )

    val locationSharedIsOpen = MutableStateFlow(true)

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
        locationDaoDomain: LocationDaoDomain
    ) = viewModelScope.launch {
        deleteLocationUseCase.execute(
            locationDaoDomain
        )
    }

    fun deleteLocationScope(
        locationDaoDomain: LocationDaoDomain
    ) = viewModelScope.launch {
        deleteLocation(
            locationDaoDomain
        )
    }

    suspend fun getLocationByCity(
        city: String
    ) = viewModelScope.launch {
        getLocationByCityUseCase.execute(
            city
        ).collect { locationItem ->
            locationDaoDomainToDelete.update {
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
        locationDaoDomain: LocationDaoDomain
    ) {
        isTrue.update {
            isTrueValue
        }
        locationDaoDomainDelete.update {
            locationDaoDomain
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

    fun getLocationShared(
        callback: (String) -> Unit,
    ) {
        val location = getLocationSharedUseCase.execute()
        val booleanValue = getBooleanSharedUseCase.execute()
        if (location.isNotEmpty() && locationSharedIsOpen.value && booleanValue) {
            locationSharedIsOpen.update {
                false
            }
            callback(location)
        }
    }

    suspend fun getLocationsWithWeather() = viewModelScope.launch {
        getAllLocations()
        val listLocations = locations.value
        val listLocationsWithWeather = mutableListOf<LocationWithWeather>()

        listLocations.forEach {
            val response = getWeatherAndWeekUseCase.execute(it.city)
            if (response.isSuccessful && response.body() != null) {
                val current = response.body()!!.currentDomain
                listLocationsWithWeather.add(
                    LocationWithWeather(
                        location = it,
                        weather = current
                    )
                )
            }
        }

        locationsWithWeather.update {
            listLocationsWithWeather
        }
    }

    fun getLocationsWithWeatherScope() = viewModelScope.launch {
        getLocationsWithWeather()
    }
}