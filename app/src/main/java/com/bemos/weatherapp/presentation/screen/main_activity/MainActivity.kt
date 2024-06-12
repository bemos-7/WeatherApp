package com.bemos.weatherapp.presentation.screen.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bemos.weatherapp.di.appComponent
import com.bemos.weatherapp.presentation.screen.cities.CitiesScreen
import com.bemos.weatherapp.presentation.screen.cities.vm.CitiesViewModel
import com.bemos.weatherapp.presentation.screen.cities.vm.factory.CitiesViewModelFactory
import com.bemos.weatherapp.ui.theme.WeatherAppTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var citiesViewModelFactory: CitiesViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent.inject(this)

        setContent {

            val viewModel = viewModel<CitiesViewModel>(
                factory = citiesViewModelFactory
            )

            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CitiesScreen(
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}
