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
import com.bemos.details_city.DetailsCityScreen
import com.bemos.details_city.vm.factory.DetailsScreenViewModelFactory
import com.bemos.details_city_future.DetailsCityFutureScreen
import com.bemos.details_city_future.vm.factory.DetailsCityFutureScreenViewModelFactory
import com.bemos.domain.model.weather_models.ForecastdayDomain
import com.bemos.home.HomeScreen
import com.bemos.home.vm.factory.HomeScreenViewModelFactory

private const val HOME = "home"
private const val DETAILS_CITY = "detailsCity/{location}"
private const val LOCATION = "location"
private const val DETAILS_CITY_FUTURE = "detailsCityFuture"
private const val FORECAST = "forecast"

@Composable
fun AppUi(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    homeScreenViewModelFactory: HomeScreenViewModelFactory,
    detailsScreenViewModelFactory: DetailsScreenViewModelFactory,
    detailsCityFutureScreenViewModelFactory: DetailsCityFutureScreenViewModelFactory
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
        route = DETAILS_CITY,
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
        navController.previousBackStackEntry?.savedStateHandle?.get<ForecastdayDomain>(FORECAST)?.let {
            DetailsCityFutureScreen(
                navController = navController,
                detailsCityFutureScreenViewModelFactory = detailsCityFutureScreenViewModelFactory,
                forecast = it
            )
        }
    }
}