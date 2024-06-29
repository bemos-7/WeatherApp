package com.bemos.weatherapp.presentation.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.weatherapp.presentation.screen.details_city.vm.DetailsWeatherIntentViewModel
import com.bemos.weatherapp.presentation.screen.home.ui_component.OpenDeleteDialog
import com.bemos.weatherapp.presentation.screen.home.vm.HomeScreenViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeScreenViewModel = viewModel(),
    detailsWeatherIntentViewModel: DetailsWeatherIntentViewModel = viewModel()
) {

    val locationsList by homeViewModel.locations.collectAsState()

    val searchCities by homeViewModel.searchCities.collectAsState()

    val isTrue by homeViewModel.isTrue.collectAsState()

    val locationDelete by homeViewModel.locationDelete.collectAsState()

    val progressBarState by homeViewModel.progressBarState.collectAsState()

    homeViewModel.getAllLocations()

    OpenDeleteDialog(
        isTrueValue = isTrue,
        onDismissRequest = {
            homeViewModel.updateIsTrue(
                false
            )
        },
        onConfirmButton = {
            homeViewModel.updateIsTrue(
                false
            )

            homeViewModel.deleteLocationScope(
                locationDelete
            )
        }
    )

    LaunchedEffect(Unit) {
        homeViewModel.getAllCities()
    }

    HomeContent(
        listCity = locationsList,
        onClick = {
            detailsWeatherIntentViewModel.updateCityDate(it)
            navController.navigate("detailsCity")
        },
        cityList = searchCities,
        searchCity = {
            homeViewModel.searchCity(it)
        },
        onClickCity = {
            detailsWeatherIntentViewModel.updateCityDate(it)
            navController.navigate("detailsCity")
        },
        onLongClick = {
            homeViewModel.updateIsTrueAndLocation(
                isTrueValue = true,
                location = it
            )
        },
        progressBarState
    )
}