package com.bemos.city.shared_preferences_repo

interface LocationManagerRepository {

    fun setLocation(location: String)

    fun getLocation(): String

}