package com.bemos.weatherapp.presentation.screen.main_activity

import android.Manifest
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.navigation.compose.rememberNavController
import com.bemos.weatherapp.di.appComponent
import com.bemos.details_city_future.vm.factory.DetailsCityFutureScreenViewModelFactory
import com.bemos.weatherapp.presentation.screen.app.AppUi
import com.bemos.weatherapp.presentation.screen.main_activity.permissions.gpsPermission
import com.bemos.weatherapp.ui.theme.WeatherAppTheme
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

        gpsPermission(this)

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
                        detailsCityFutureScreenViewModelFactory = detailsCityFutureScreenViewModelFactory,
                    )
                }
            }
        }
    }
}