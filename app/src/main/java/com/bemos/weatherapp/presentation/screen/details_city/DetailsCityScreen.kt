package com.bemos.weatherapp.presentation.screen.details_city

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.weatherapp.presentation.screen.details_city.vm.DetailsScreenViewModel
import com.bemos.weatherapp.presentation.screen.details_city.vm.DetailsWeatherIntentViewModel

@Composable
fun DetailsCityScreen(
    navController: NavController,
    detailsWeatherIntentViewModel: DetailsWeatherIntentViewModel = viewModel(),
    detailsScreenViewModel: DetailsScreenViewModel = viewModel()
) {

    val weatherDetails by detailsWeatherIntentViewModel.weather.collectAsState()

    val weatherAndMore by detailsScreenViewModel.weatherAndForecast.collectAsState()

    val weatherByTheHour by detailsScreenViewModel.weatherByTheHour.collectAsState()

    val addCheck by detailsScreenViewModel.insertChecker.collectAsState()

    LaunchedEffect(Unit) {
        detailsScreenViewModel.getWeatherAndForecast(
            weatherDetails
        )
    }

    DetailsCityContent(
        weatherDetailsAndMore = weatherAndMore,
        weatherByTheHour = weatherByTheHour,
        onBackClick = {
            navController.navigate("home")
        },
        onPlusClick = {

        },
        addCheck
    )

}