package com.bemos.city.shared_preferences_repo

interface LocationPreviewManagerRepository {

    fun setLocation(value: Boolean)

    fun getLocation(): Boolean

}