package com.bemos.settings.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.domain.model.Location
import com.bemos.domain.use_cases.GetAllLoationsUseCase
import com.bemos.domain.use_cases.GetLocationSharedUseCase
import com.bemos.domain.use_cases.SetLocationSharedUseCase
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsScreenViewModel(
    private val getAllLocationsUseCase: GetAllLoationsUseCase,
    private val setLocationSharedUseCase: SetLocationSharedUseCase,
    private val getLocationSharedUseCase: GetLocationSharedUseCase
) : ViewModel() {

    val locations = MutableStateFlow<List<Location>>(
        listOf()
    )

    val shared = MutableStateFlow("")

    suspend fun getAllLocations() = viewModelScope.launch {
        getAllLocationsUseCase.execute()
            .collect { listLocations ->
                locations.update {
                    listLocations
                }
            }
    }

    fun setLocation(
        location: String
    ) {
        setLocationSharedUseCase.execute(
            location
        )
    }

    fun getLocation() {
        val location = getLocationSharedUseCase.execute()
        shared.update {
            location
        }
    }

}