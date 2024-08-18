package com.bemos.feature.service.map

import org.osmdroid.views.MapView

interface MapRepository {

    fun getMap()

    fun getMapView(): MapView

    fun getUserGeoPoint()

}