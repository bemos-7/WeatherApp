package com.bemos.details_city

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.core.Constants.DETAILS_CITY_FUTURE
import com.bemos.core.Constants.FORECAST
import com.bemos.details_city.vm.DetailsScreenViewModel
import com.bemos.details_city.vm.factory.DetailsScreenViewModelFactory

@Composable
fun DetailsCityScreen(
    navController: NavController,
    location: String?,
    detailsScreenViewModelFactory: DetailsScreenViewModelFactory
) {

    val detailsScreenViewModel = viewModel<DetailsScreenViewModel>(
        factory = detailsScreenViewModelFactory
    )

    val weatherAndMore by detailsScreenViewModel.weatherAndForecast.collectAsState()

    val weatherByTheHour by detailsScreenViewModel.weatherByTheHour.collectAsState()

    val forecastDayAndIcon by detailsScreenViewModel.forecastDayAndIcon.collectAsState()

    val insertChecker by detailsScreenViewModel.insertChecker.collectAsState()

    val progressBarState by detailsScreenViewModel.progressBarState.collectAsState()

    val networkState by detailsScreenViewModel.networkState.collectAsState()

    detailsScreenViewModel.checkInternet()

    com.bemos.shared.ui_components.OpenNetworkDialog(
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
        detailsScreenViewModel.getLocationByCity(location.toString())
        detailsScreenViewModel.getWeatherAndForecast(location.toString())
    }

    DetailsCityContent(
        weatherDetailsAndMore = weatherAndMore,
        weatherByTheHour = weatherByTheHour,
        forecastDayAndIcon = forecastDayAndIcon,
        onBackClick = {
            navController.popBackStack()
        },
        onPlusClick = {
            detailsScreenViewModel.insertLocationRunWithScope(it)
        },
        addCheck = insertChecker,
        progressBarState,
        onForecastCLick = {
//            detailsWeatherIntentViewModel.updateForecastDay(
//                it
//            )
//            val forecastJson = Gson().toJson(it).toString()
            navController.currentBackStackEntry?.savedStateHandle?.set(FORECAST, it)
            navController.navigate(DETAILS_CITY_FUTURE)
        }
    )

}