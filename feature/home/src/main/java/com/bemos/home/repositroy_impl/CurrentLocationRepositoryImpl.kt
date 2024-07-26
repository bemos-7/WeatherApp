package com.bemos.home.repositroy_impl

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import com.bemos.domain.repositories.CurrentLocationRepository
import com.google.android.gms.location.FusedLocationProviderClient

class CurrentLocationRepositoryImpl(
    private val fusedLocationProviderClient: FusedLocationProviderClient,
    private val context: Context
) : CurrentLocationRepository {
    override fun getCurrentLocation(
        geoPointCallBack: (String) -> Unit
    ) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            geoPointCallBack("permission_not_accept")
        }
        val location = fusedLocationProviderClient.lastLocation
        location.addOnSuccessListener {
            if (it != null) {
                val geoPoint = "${it.latitude},${it.longitude}"
                Log.d("locationCurrent", geoPoint)
                geoPointCallBack(geoPoint)
            }
        }

    }
}