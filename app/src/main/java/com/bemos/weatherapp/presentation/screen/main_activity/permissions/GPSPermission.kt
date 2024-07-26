package com.bemos.weatherapp.presentation.screen.main_activity.permissions

import android.Manifest
import android.app.Activity
import androidx.core.app.ActivityCompat

fun gpsPermission(
    activity: Activity
) {
    ActivityCompat.requestPermissions(
        activity,
        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100
    )
}