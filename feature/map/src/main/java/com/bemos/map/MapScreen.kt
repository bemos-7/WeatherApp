package com.bemos.map

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.feature.service.map.MapRepository
import com.bemos.map.vm.MapScreenViewModel
import com.bemos.map.vm.MapScreenViewModelFactory
import com.bemos.shared.Constants.DETAILS_CITY
import org.osmdroid.views.MapView

@Composable
fun MapScreen(
    navController: NavController,
    mapScreenViewModelFactory: MapScreenViewModelFactory,
    mapRepository: MapRepository
) {
    mapRepository.getMap()

    val mapViewModel = viewModel<MapScreenViewModel>(
        factory = mapScreenViewModelFactory
    )

    val context = LocalContext.current
    val mapView = remember {
        MapView(context)
    }

    MapContent(
        mapView = mapView,
        onUserGeoPointClick = {
            mapRepository.getUserGeoPoint(
                mapView
            )
        },
        onMapClick = {
            navController.navigate("$DETAILS_CITY/${it}")
        }
    )
}