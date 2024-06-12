package com.bemos.weatherapp.presentation.screen.cities

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bemos.weatherapp.presentation.screen.cities.vm.CitiesViewModel

@Composable
fun CitiesScreen(
    viewModel: CitiesViewModel = viewModel()
) {

    val t by viewModel.temperature.collectAsState()

    val city = remember {
        mutableStateOf("Moscow")
    }

    LaunchedEffect(Unit) {
        viewModel.getWeather(
            city.value
        )
    }

    Log.d("weatherGavnoPolnoe", t)

    CitiesContent(
        onClick = {
            city.value = it
        },
        temp = t
    )
}