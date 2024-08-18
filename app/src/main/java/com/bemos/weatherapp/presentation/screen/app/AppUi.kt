package com.bemos.weatherapp.presentation.screen.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.bemos.shared.Constants.DETAILS_CITY_WITH_LOCATION
import com.bemos.shared.Constants.DETAILS_CITY_FUTURE
import com.bemos.shared.Constants.FORECAST
import com.bemos.shared.Constants.HOME
import com.bemos.shared.Constants.LOCATION
import com.bemos.shared.Constants.SETTINGS
import com.bemos.details_city.DetailsCityScreen
import com.bemos.details_city.vm.factory.DetailsScreenViewModelFactory
import com.bemos.details_city_future.DetailsCityFutureScreen
import com.bemos.details_city_future.vm.factory.DetailsCityFutureScreenViewModelFactory
import com.bemos.feature.service.map.MapRepository
import com.bemos.home.HomeScreen
import com.bemos.home.vm.factory.HomeScreenViewModelFactory
import com.bemos.map.MapScreen
import com.bemos.map.vm.MapScreenViewModelFactory
import com.bemos.settings.SettingsScreen
import com.bemos.settings.vm.factory.SettingsScreenViewModelFactory
import com.bemos.shared.Constants.MAP

@Composable
fun AppUi(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    homeScreenViewModelFactory: HomeScreenViewModelFactory,
    detailsScreenViewModelFactory: DetailsScreenViewModelFactory,
    detailsCityFutureScreenViewModelFactory: DetailsCityFutureScreenViewModelFactory,
    settingsScreenViewModelFactory: SettingsScreenViewModelFactory,
    mapScreenViewModelFactory: MapScreenViewModelFactory,
    mapRepository: MapRepository
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = HOME
    ) {
        home(
            navController,
            homeScreenViewModelFactory
        )
        detailsCity(
            navController,
            detailsScreenViewModelFactory
        )
        detailsCityFuture(
            navController,
            detailsCityFutureScreenViewModelFactory
        )
        settings(
            navController,
            settingsScreenViewModelFactory
        )
        map(
            navController,
            mapScreenViewModelFactory,
            mapRepository
        )
    }

}

private fun NavGraphBuilder.home(
    navController: NavController,
    homeScreenViewModelFactory: HomeScreenViewModelFactory
) {
    composable(
        route = HOME
    ) {
        HomeScreen(
            navController = navController,
            homeViewModelFactory = homeScreenViewModelFactory,
        )
    }
}

private fun NavGraphBuilder.detailsCity(
    navController: NavController,
    detailsScreenViewModelFactory: DetailsScreenViewModelFactory,
) {
    composable(
        route = DETAILS_CITY_WITH_LOCATION,
        arguments = listOf(
            navArgument(LOCATION) {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->
        DetailsCityScreen(
            navController = navController,
            location = navBackStackEntry.arguments?.getString(LOCATION),
            detailsScreenViewModelFactory = detailsScreenViewModelFactory
        )
    }
}

private fun NavGraphBuilder.detailsCityFuture(
    navController: NavController,
    detailsCityFutureScreenViewModelFactory: DetailsCityFutureScreenViewModelFactory
) {
    composable(
        route = DETAILS_CITY_FUTURE
    ) {
        navController.previousBackStackEntry?.savedStateHandle?.get<com.bemos.domain.model.weather_models.ForecastdayDomain>(FORECAST)?.let {
            DetailsCityFutureScreen(
                navController = navController,
                detailsCityFutureScreenViewModelFactory = detailsCityFutureScreenViewModelFactory,
                forecast = it
            )
        }
    }
}

private fun NavGraphBuilder.settings(
    navController: NavController,
    settingsScreenViewModelFactory: SettingsScreenViewModelFactory
) {
    composable(
        route = SETTINGS
    ) {
        SettingsScreen(
            navController = navController,
            settingsScreenViewModelFactory = settingsScreenViewModelFactory
        )
    }
}

private fun NavGraphBuilder.map(
    navController: NavController,
    mapScreenViewModelFactory: MapScreenViewModelFactory,
    mapRepository: MapRepository
) {
    composable(
        route = MAP
    ) {
        MapScreen(
            navController,
            mapScreenViewModelFactory,
            mapRepository
        )
    }
}