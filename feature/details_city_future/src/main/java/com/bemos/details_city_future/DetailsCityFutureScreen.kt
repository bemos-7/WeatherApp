package com.bemos.details_city_future

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.details_city_future.vm.DetailsCityFutureScreenViewModel
import com.bemos.details_city_future.vm.factory.DetailsCityFutureScreenViewModelFactory
import com.bemos.domain.model.weather_models.ForecastdayDomain

@Composable
fun DetailsCityFutureScreen(
    navController: NavController,
    detailsCityFutureScreenViewModelFactory: DetailsCityFutureScreenViewModelFactory,
    forecast: ForecastdayDomain
) {

    val detailsCityFutureScreenViewModel = viewModel<DetailsCityFutureScreenViewModel>(
        factory = detailsCityFutureScreenViewModelFactory
    )

    val forecastDayDF by detailsCityFutureScreenViewModel.forecastDay.collectAsState()

    LaunchedEffect(Unit) {
        detailsCityFutureScreenViewModel.covertToForecastDetailCF(
            forecast!!
        )
    }

    DetailsCityFutureContent(
        onBackClick = {
            navController.popBackStack()
        },
        forecastDayDF
    )
}