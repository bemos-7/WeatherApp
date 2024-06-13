package com.bemos.weatherapp.presentation.screen.details_city

import android.util.Log
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

    Log.d("PogodaPloxaiPogodar", weatherDetails)

    LaunchedEffect(Unit) {
        detailsScreenViewModel.getWeatherByCity(
            weatherDetails
        )
    }

    val weather by detailsScreenViewModel.weather.collectAsState()

    DetailsCityContent(
        weatherDetails = weather
    )

}