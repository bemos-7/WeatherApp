package com.bemos.settings

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bemos.settings.vm.SettingsScreenViewModel
import com.bemos.settings.vm.factory.SettingsScreenViewModelFactory

@Composable
fun SettingsScreen(
    navController: NavController,
    settingsScreenViewModelFactory: SettingsScreenViewModelFactory
) {
    val settingsViewModel = viewModel<SettingsScreenViewModel>(
        factory = settingsScreenViewModelFactory
    )

    val locations by settingsViewModel.locations.collectAsState()

    val shared by settingsViewModel.shared.collectAsState()

    val booleanShared by settingsViewModel.booleanShared.collectAsState()

    LaunchedEffect(Unit) {
        settingsViewModel.getAllLocations()
        settingsViewModel.getLocation()
        settingsViewModel.getBooleanShared()
    }
    Log.d("booleanCheck", booleanShared.toString())

    Log.d("sharedCheck", shared)

    SettingsContent(
        onBackClick = {
            navController.popBackStack()
        },
        dropdownItems = locations,
        onDropDownItemClick = {
            settingsViewModel.setLocation(it)
        },
        onCheckedChange = {
            settingsViewModel.setBooleanShared(
                it
            )
        },
        booleanShared
    )
}