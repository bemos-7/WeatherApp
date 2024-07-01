package com.bemos.weatherapp.presentation.screen.details_city

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.weatherapp.presentation.screen.details_city.vm.DetailsScreenViewModel
import com.bemos.weatherapp.presentation.screen.details_city.vm.DetailsWeatherIntentViewModel
import com.bemos.weatherapp.presentation.ui_component.OpenDeleteDialogNetwork

@Composable
fun DetailsCityScreen(
    navController: NavController,
    detailsWeatherIntentViewModel: DetailsWeatherIntentViewModel = viewModel(),
    detailsScreenViewModel: DetailsScreenViewModel = viewModel()
) {

    val weatherDetails by detailsWeatherIntentViewModel.weather.collectAsState()

    val weatherAndMore by detailsScreenViewModel.weatherAndForecast.collectAsState()

    val weatherByTheHour by detailsScreenViewModel.weatherByTheHour.collectAsState()

    val insertChecker by detailsScreenViewModel.insertChecker.collectAsState()

    val progressBarState by detailsScreenViewModel.progressBarState.collectAsState()

    val networkState by detailsScreenViewModel.networkState.collectAsState()

    detailsScreenViewModel.checkInternet()

    OpenDeleteDialogNetwork(
        networkState = networkState,
        onDismissRequest = {
            detailsScreenViewModel.checkInternet()
            detailsScreenViewModel.controlNavigation(navController)
        },
        onConfirmButton = {
            detailsScreenViewModel.checkInternet()
            detailsScreenViewModel.controlNavigation(navController)
        }
    )

    LaunchedEffect(Unit) {
        detailsScreenViewModel.getLocationByCity(weatherDetails)
        detailsScreenViewModel.getWeatherAndForecast(weatherDetails)
    }

    DetailsCityContent(
        weatherDetailsAndMore = weatherAndMore,
        weatherByTheHour = weatherByTheHour,
        onBackClick = {
            navController.popBackStack()
        },
        onPlusClick = {
            detailsScreenViewModel.insertLocationRunWithScope(it)
        },
        addCheck = insertChecker,
        progressBarState
    )

}