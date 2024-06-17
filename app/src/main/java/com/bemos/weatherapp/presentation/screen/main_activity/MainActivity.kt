package com.bemos.weatherapp.presentation.screen.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bemos.weatherapp.di.appComponent
import com.bemos.weatherapp.presentation.screen.details_city.DetailsCityScreen
import com.bemos.weatherapp.presentation.screen.details_city.vm.DetailsScreenViewModel
import com.bemos.weatherapp.presentation.screen.details_city.vm.DetailsWeatherIntentViewModel
import com.bemos.weatherapp.presentation.screen.details_city.vm.factory.DetailsScreenViewModelFactory
import com.bemos.weatherapp.presentation.screen.home.HomeScreen
import com.bemos.weatherapp.presentation.screen.home.vm.HomeScreenViewModel
import com.bemos.weatherapp.presentation.screen.home.vm.factory.HomeScreenViewModelFactory
import com.bemos.weatherapp.ui.theme.WeatherAppTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var detailsScreenViewModelFactory: DetailsScreenViewModelFactory

    @Inject
    lateinit var homeScreenViewModelFactory: HomeScreenViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent.inject(this)

        setContent {
            val navController = rememberNavController()

            val detailsViewModel = viewModel<DetailsScreenViewModel>(
                factory = detailsScreenViewModelFactory
            )

            val detailsWeatherIntentViewModel = viewModel<DetailsWeatherIntentViewModel>()

            val homeViewModel = viewModel<HomeScreenViewModel>(
                factory = homeScreenViewModelFactory
            )

            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "home"
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
                }
            }
        }
    }
}
