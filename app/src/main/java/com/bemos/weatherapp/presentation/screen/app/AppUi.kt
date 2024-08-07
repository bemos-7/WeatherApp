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
import com.bemos.core.Constants.DETAILS_CITY_WITH_LOCATION
import com.bemos.core.Constants.DETAILS_CITY_FUTURE
import com.bemos.core.Constants.FORECAST
import com.bemos.core.Constants.HOME
import com.bemos.core.Constants.LOCATION
import com.bemos.core.Constants.SETTINGS
import com.bemos.details_city.DetailsCityScreen
import com.bemos.details_city.vm.factory.DetailsScreenViewModelFactory
import com.bemos.details_city_future.DetailsCityFutureScreen
import com.bemos.details_city_future.vm.factory.DetailsCityFutureScreenViewModelFactory
import com.bemos.domain.model.weather_models.ForecastdayDomain
import com.bemos.home.HomeScreen
import com.bemos.home.vm.factory.HomeScreenViewModelFactory
import com.bemos.settings.SettingsScreen
import com.bemos.settings.vm.factory.SettingsScreenViewModelFactory

@Composable
fun AppUi(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    homeScreenViewModelFactory: HomeScreenViewModelFactory,
    detailsScreenViewModelFactory: DetailsScreenViewModelFactory,
    detailsCityFutureScreenViewModelFactory: DetailsCityFutureScreenViewModelFactory,
    settingsScreenViewModelFactory: SettingsScreenViewModelFactory
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
