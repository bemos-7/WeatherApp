package com.bemos.data.local.shared_preferences.repository_impl.preview_location

import android.content.Context
import androidx.core.content.edit
import com.bemos.shared.Constants.LOCATION_KEY
import com.bemos.shared.Constants.SHARED_PREF
import com.bemos.city.shared_preferences_repo.LocationManagerRepository

class LocationManagerRepositoryImpl(
    private val context: Context
) : LocationManagerRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
    override fun setLocation(location: String) {
        sharedPreferences.edit {
            putString(LOCATION_KEY, location)
        }
    }

    override fun getLocation(): String {
        val location = sharedPreferences.getString(LOCATION_KEY, "")
        return location.toString()
    }
}