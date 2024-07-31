package com.bemos.settings.repository_impl

import android.content.Context
import androidx.core.content.edit
import com.bemos.domain.repositories.LocationManagerRepository


private const val SHARED_PREF = "sharedPref"
private const val LOCATION_KEY = "locationKey"

class LocationManagerRepositoryImpl(
    private val context: Context
) : LocationManagerRepository {
    override fun setLocation(location: String) {
        val sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        sharedPreferences.edit {
            putString(LOCATION_KEY, location)
        }
    }

    override fun getLocation(): String {
        val sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        val location = sharedPreferences.getString(LOCATION_KEY, "")
        return location.toString()
    }
}