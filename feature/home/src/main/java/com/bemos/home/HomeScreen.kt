package com.bemos.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.shared.ui_components.OpenDeleteDialog
import com.bemos.home.vm.HomeScreenViewModel
import com.bemos.home.vm.factory.HomeScreenViewModelFactory
import com.bemos.shared.ui_components.OpenDialogNetwork

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModelFactory: HomeScreenViewModelFactory
//    detailsWeatherIntentViewModel: DetailsWeatherIntentViewModel = viewModel(),
) {

    val homeViewModel = viewModel<HomeScreenViewModel>(
        factory = homeViewModelFactory
    )

    val locationsList by homeViewModel.locations.collectAsState()

    val searchCities by homeViewModel.searchCities.collectAsState()

    val isTrue by homeViewModel.isTrue.collectAsState()

    val locationDelete by homeViewModel.locationDelete.collectAsState()

    val networkState by homeViewModel.networkState.collectAsState()

    homeViewModel.checkInternet()

    homeViewModel.getAllLocations()

    com.bemos.shared.ui_components.OpenDialogNetwork(
        networkState = networkState,
        onDismissRequest = {
            homeViewModel.checkInternet()
        },
        onConfirmButton = {
            homeViewModel.checkInternet()
        }
    )

    com.bemos.shared.ui_components.OpenDeleteDialog(
        isTrueValue = isTrue,
        onDismissRequest = {
            homeViewModel.updateIsTrue(
                false
            )
        },
        onConfirmButton = {
            homeViewModel.updateIsTrue(
                false
            )

            homeViewModel.deleteLocationScope(
                locationDelete
            )
        }
    )

    LaunchedEffect(Unit) {
        homeViewModel.getAllCities()
    }

    HomeContent(
        listCity = locationsList,
        onClick = {
//            detailsWeatherIntentViewModel.updateCityDate(it)
            navController.navigate("detailsCity/$it")
        },
        cityList = searchCities,
        searchCity = {
            homeViewModel.searchCity(it)
        },
        onClickCity = {
//            detailsWeatherIntentViewModel.updateCityDate(it)
            navController.navigate("detailsCity/$it")
        },
        onLongClick = {
            homeViewModel.updateIsTrueAndLocation(
                isTrueValue = true,
                location = it
            )
        }
    )
}