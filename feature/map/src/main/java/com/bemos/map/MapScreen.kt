package com.bemos.map

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.map.vm.MapScreenViewModel
import com.bemos.map.vm.MapScreenViewModelFactory

@Composable
fun MapScreen(
    navController: NavController,
    mapScreenViewModelFactory: MapScreenViewModelFactory
) {
    val mapViewModel = viewModel<MapScreenViewModel>(
        factory = mapScreenViewModelFactory
    )

    val mapView by mapViewModel.mapViewGetter.collectAsState()

    MapContent(
        mapView = mapView!!,
        onUserGeoPointClick = {
            mapViewModel.getUserGeoPoint()
        }
    )
}