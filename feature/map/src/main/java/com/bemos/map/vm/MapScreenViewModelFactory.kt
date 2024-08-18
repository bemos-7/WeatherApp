package com.bemos.map.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bemos.feature.service.map.MapRepository

class MapScreenViewModelFactory(
    private val mapRepository: MapRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MapScreenViewModel(
            mapRepository = mapRepository
        ) as T
    }
}