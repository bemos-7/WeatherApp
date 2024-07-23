package com.bemos.weatherapp.presentation.screen.main_activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.bemos.details_city.DetailsCityScreen
import com.bemos.weatherapp.di.appComponent
import com.bemos.details_city_future.DetailsCityFutureScreen
import com.bemos.details_city_future.vm.factory.DetailsCityFutureScreenViewModelFactory
import com.bemos.domain.model.weather_models.AstroDomain
import com.bemos.domain.model.weather_models.ForecastdayDomain
import com.bemos.home.HomeScreen
import com.bemos.weatherapp.presentation.screen.app.AppUi
import com.bemos.weatherapp.ui.theme.WeatherAppTheme
import com.google.gson.Gson
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var detailsScreenViewModelFactory: com.bemos.details_city.vm.factory.DetailsScreenViewModelFactory

    @Inject
    lateinit var homeScreenViewModelFactory: com.bemos.home.vm.factory.HomeScreenViewModelFactory

    @Inject
    lateinit var detailsCityFutureScreenViewModelFactory: DetailsCityFutureScreenViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent.inject(this)

        setContent {
            val navController = rememberNavController()

            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppUi(
                        navController = navController,
                        homeScreenViewModelFactory = homeScreenViewModelFactory,
                        detailsScreenViewModelFactory = detailsScreenViewModelFactory,
                        detailsCityFutureScreenViewModelFactory = detailsCityFutureScreenViewModelFactory
                    )
                }
            }
        }
    }
}
