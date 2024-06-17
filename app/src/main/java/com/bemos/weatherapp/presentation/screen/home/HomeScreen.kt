package com.bemos.weatherapp.presentation.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.weatherapp.presentation.screen.details_city.vm.DetailsWeatherIntentViewModel
import com.bemos.weatherapp.presentation.screen.home.vm.HomeScreenViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeScreenViewModel = viewModel(),
    detailsWeatherIntentViewModel: DetailsWeatherIntentViewModel = viewModel()
) {

    val locationsList by homeViewModel.locations.collectAsState()

    val searchCities by homeViewModel.searchCities.collectAsState()

    homeViewModel.getAllLocations()

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
        }
    )

}