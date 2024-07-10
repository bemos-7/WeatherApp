package com.bemos.weatherapp.presentation.screen.detail_city_future

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.weatherapp.presentation.screen.detail_city_future.vm.DetailsCityFutureScreenViewModel
import com.bemos.weatherapp.presentation.screen.details_city.vm.DetailsWeatherIntentViewModel

@Composable
fun DetailsCityFutureScreen(
    navController: NavController,
    detailsCityFutureScreenViewModel: DetailsCityFutureScreenViewModel = viewModel(),
    detailsWeatherIntentViewModel: DetailsWeatherIntentViewModel = viewModel()
) {
    val forecastDay by detailsWeatherIntentViewModel.forecastDay.collectAsState()

    val forecastDayDF by detailsCityFutureScreenViewModel.forecastDay.collectAsState()

    LaunchedEffect(Unit) {
        detailsCityFutureScreenViewModel.covertToForecastDetailCF(
            forecastDay!!
        )
    }

    DetailsCityFutureContent(
        onBackClick = {
            navController.popBackStack()
        },
        forecastDayDF
    )
}