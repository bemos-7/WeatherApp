package com.bemos.weatherapp.presentation.screen.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bemos.weatherapp.presentation.screen.detail_city_future.DetailsCityFutureScreen
import com.bemos.weatherapp.presentation.screen.detail_city_future.vm.DetailsCityFutureScreenViewModel
import com.bemos.weatherapp.presentation.screen.details_city.DetailsCityScreen
import com.bemos.weatherapp.presentation.screen.details_city.vm.DetailsScreenViewModel
import com.bemos.weatherapp.presentation.screen.details_city.vm.DetailsWeatherIntentViewModel
import com.bemos.weatherapp.presentation.screen.home.HomeScreen
import com.bemos.weatherapp.presentation.screen.home.vm.HomeScreenViewModel

@Composable
fun AppUi(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    homeViewModel: HomeScreenViewModel,
    detailsViewModel: DetailsScreenViewModel,
    detailsWeatherIntentViewModel: DetailsWeatherIntentViewModel,
    detailsCityFutureScreenViewModel: DetailsCityFutureScreenViewModel,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "home"
    ) {
        home(
            navController = navController,
            homeViewModel = homeViewModel,
            detailsWeatherIntentViewModel = detailsWeatherIntentViewModel,
        )
        detailsCity(
            navController = navController,
            detailsViewModel = detailsViewModel,
            detailsWeatherIntentViewModel = detailsWeatherIntentViewModel,
        )
        detailsCityFuture(
            navController = navController,
            detailsCityFutureScreenViewModel = detailsCityFutureScreenViewModel,
            detailsWeatherIntentViewModel = detailsWeatherIntentViewModel,
        )
    }
}


private fun NavGraphBuilder.home(
    navController: NavController,
    homeViewModel: HomeScreenViewModel,
    detailsWeatherIntentViewModel: DetailsWeatherIntentViewModel,
) {
    composable(
        route = "home"
    ) {
        HomeScreen(
            navController = navController,
            homeViewModel = homeViewModel,
            detailsWeatherIntentViewModel = detailsWeatherIntentViewModel
        )
    }
}

private fun NavGraphBuilder.detailsCity(
    navController: NavController,
    detailsViewModel: DetailsScreenViewModel,
    detailsWeatherIntentViewModel: DetailsWeatherIntentViewModel,
) {
    composable(
        route = "detailsCity"
    ) {
        DetailsCityScreen(
            navController = navController,
            detailsWeatherIntentViewModel = detailsWeatherIntentViewModel,
            detailsScreenViewModel = detailsViewModel
        )
    }
}

private fun NavGraphBuilder.detailsCityFuture(
    navController: NavController,
    detailsCityFutureScreenViewModel: DetailsCityFutureScreenViewModel,
    detailsWeatherIntentViewModel: DetailsWeatherIntentViewModel,
) {
    composable(
        route = "detailsCityFuture"
    ) {
        DetailsCityFutureScreen(
            navController = navController,
            detailsCityFutureScreenViewModel = detailsCityFutureScreenViewModel,
            detailsWeatherIntentViewModel = detailsWeatherIntentViewModel
        )
    }
}

