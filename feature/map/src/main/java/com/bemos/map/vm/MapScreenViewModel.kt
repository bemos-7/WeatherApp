package com.bemos.map.vm

import androidx.lifecycle.ViewModel
import com.bemos.feature.service.map.MapRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import org.osmdroid.views.MapView

class MapScreenViewModel(
    private val mapRepository: MapRepository
) : ViewModel() {


}