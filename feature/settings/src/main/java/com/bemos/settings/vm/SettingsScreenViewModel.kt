package com.bemos.settings.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.domain.model.LocationDaoDomain
import com.bemos.domain.use_cases.GetAllLoationsUseCase
import com.bemos.domain.use_cases.GetBooleanSharedUseCase
import com.bemos.domain.use_cases.GetLocationSharedUseCase
import com.bemos.domain.use_cases.SetBooleanSharedUseCase
import com.bemos.domain.use_cases.SetLocationSharedUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsScreenViewModel(
    private val getAllLocationsUseCase: GetAllLoationsUseCase,
    private val setLocationSharedUseCase: SetLocationSharedUseCase,
    private val getLocationSharedUseCase: GetLocationSharedUseCase,
    private val setBooleanSharedUseCase: SetBooleanSharedUseCase,
    private val getBooleanSharedUseCase: GetBooleanSharedUseCase
) : ViewModel() {

    val locations = MutableStateFlow<List<com.bemos.domain.model.LocationDaoDomain>>(
        listOf()
    )

    val shared = MutableStateFlow("")

    val booleanShared = MutableStateFlow(false)

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

    fun setBooleanShared(value: Boolean) {
        setBooleanSharedUseCase.execute(value)
    }
    fun getBooleanShared() {
        val value = getBooleanSharedUseCase.execute()
        booleanShared.update {
            value
        }
    }

}