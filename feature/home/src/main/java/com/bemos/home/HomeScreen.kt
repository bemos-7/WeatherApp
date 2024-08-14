package com.bemos.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.shared.Constants.DETAILS_CITY
import com.bemos.shared.Constants.SETTINGS
import com.bemos.home.vm.HomeScreenViewModel
import com.bemos.home.vm.factory.HomeScreenViewModelFactory
import com.bemos.shared.OpenNetworkDialog

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModelFactory: HomeScreenViewModelFactory
) {

    val homeViewModel = viewModel<HomeScreenViewModel>(
        factory = homeViewModelFactory
    )

    val locationsList by homeViewModel.locations.collectAsState()

    val locationWithWeather by homeViewModel.locationsWithWeather.collectAsState()

    val searchCities by homeViewModel.searchCities.collectAsState()

    val isTrue by homeViewModel.isTrue.collectAsState()

    val locationDelete by homeViewModel.locationDaoDomainDelete.collectAsState()

    val networkState by homeViewModel.networkState.collectAsState()

    val locationIsOpen by homeViewModel.locationSharedIsOpen.collectAsState()

    homeViewModel.checkInternet()

    homeViewModel.getLocationsWithWeatherScope()

    Log.d("checkWeather", locationWithWeather.toString())

    OpenNetworkDialog(
        networkState = networkState,
        onDismissRequest = {
            homeViewModel.checkInternet()
        },
        onConfirmButton = {
            homeViewModel.checkInternet()
        }
    )

    com.bemos.shared.OpenDeleteDialog(
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
    Log.d("locationIsOpen", locationIsOpen.toString())

    homeViewModel.getLocationShared {
        navController.navigate("${DETAILS_CITY}/$it")
    }

    LaunchedEffect(Unit) {
        homeViewModel.getAllCities()
    }

    HomeContent(
        listCity = locationsList,
        listLocationsWithWeather = locationWithWeather,
        onClick = {
            navController.navigate("${DETAILS_CITY}/$it")
        },
        cityList = searchCities,
        searchCity = {
            homeViewModel.searchCity(it)
        },
        onClickCity = {
            navController.navigate("${DETAILS_CITY}/$it")
        },
        onLongClick = {
            homeViewModel.updateIsTrueAndLocation(
                isTrueValue = true,
                locationDaoDomain = it
            )
        },
        onLocationClick = {
            homeViewModel.getCurrentLocation {

                if (it.isEmpty()) {
                    Log.d("locationCurrent", "it")
                }
                navController.navigate("${DETAILS_CITY}/$it")
            }
        },
        onBurgerClick = {
            navController.navigate(SETTINGS)
        }
    )
}