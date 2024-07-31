package com.bemos.domain.repositories

interface CurrentLocationRepository {

    fun getCurrentLocation(geoPointCallBack: (String?) -> Unit)

}