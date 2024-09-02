package com.bemos.details_city

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.details_city.model.WeatherByTheHourVisibleMode
import com.bemos.details_city.ui_component.ForecastDayDialog
import com.bemos.shared.Constants.DETAILS_CITY_FUTURE
import com.bemos.shared.Constants.FORECAST
import com.bemos.details_city.vm.DetailsScreenViewModel
import com.bemos.details_city.vm.factory.DetailsScreenViewModelFactory
import com.bemos.shared.ui.ui_components.OpenNetworkDialog

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

    val forecastDayState by detailsScreenViewModel.forecastDayState.collectAsState()

    detailsScreenViewModel.checkInternet()

    OpenNetworkDialog(
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


        ForecastDayDialog(
            weatherByTheHourVisibleMode = forecastDayState,
            onDismissRequest = {
                detailsScreenViewModel.updateWeatherByTheHourVisibleMode(
                    WeatherByTheHourVisibleMode(
                        null,
                        false
                    )
                )
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
            navController.currentBackStackEntry?.savedStateHandle?.set(FORECAST, it)
            navController.navigate(DETAILS_CITY_FUTURE)
        },
        onForecastDayClick = {
            detailsScreenViewModel.updateWeatherByTheHourVisibleMode(
                WeatherByTheHourVisibleMode(
                    it,
                    true
                )
            )
        }
    )

}