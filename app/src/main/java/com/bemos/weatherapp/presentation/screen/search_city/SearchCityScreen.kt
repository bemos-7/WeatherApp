package com.bemos.weatherapp.presentation.screen.search_city

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bemos.weatherapp.presentation.screen.search_city.vm.SearchCityViewModel

@Composable
fun SearchCityScreen(
    searchCityViewModel: SearchCityViewModel = viewModel()
) {

    val cities by searchCityViewModel.cities.collectAsState()

    LaunchedEffect(Unit) {
        searchCityViewModel.getAllCities()
    }

    SearchCityContent(
        cityList = cities
    )

}