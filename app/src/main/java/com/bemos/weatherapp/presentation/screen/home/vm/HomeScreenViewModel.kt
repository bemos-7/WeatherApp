package com.bemos.weatherapp.presentation.screen.home.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bemos.weatherapp.domain.model.Location
import com.bemos.weatherapp.domain.use_cases.GetAllLoationsUseCase
import com.bemos.weatherapp.domain.use_cases.InsertLocationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getAllLoationsUseCase: GetAllLoationsUseCase,
    private val insertLocationUseCase: InsertLocationUseCase
) : ViewModel() {

    val locations = MutableStateFlow<List<Location>>(emptyList())

    fun getAllLocations() = viewModelScope.launch {
        getAllLoationsUseCase.execute()
            .collect { listLocation ->
                locations.update {
                    listLocation
                }
            }
    }

    fun insertLocation(
        location: Location
    ) = viewModelScope.launch {
        insertLocationUseCase.execute(
            location
        )
    }


}