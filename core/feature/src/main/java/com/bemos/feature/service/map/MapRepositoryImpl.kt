package com.bemos.feature.service.map

import android.content.Context
import com.bemos.shared.Constants.MAP_SHARED_PREFERENCES
import org.osmdroid.config.Configuration
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

class MapRepositoryImpl(
    private val context: Context,
    private val mapView: MapView
) : MapRepository {

    private val sharedPreferences = context.getSharedPreferences(MAP_SHARED_PREFERENCES, Context.MODE_PRIVATE)

    override fun getMap() {
        Configuration.getInstance().load(context, sharedPreferences)
    }

    override fun getMapView(): MapView {
        return mapView
    }

    override fun getUserGeoPoint() {
        val locationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(context), mapView)
        locationOverlay.enableMyLocation()
        locationOverlay.enableFollowLocation()
        mapView.overlays.add(locationOverlay)
    }

}