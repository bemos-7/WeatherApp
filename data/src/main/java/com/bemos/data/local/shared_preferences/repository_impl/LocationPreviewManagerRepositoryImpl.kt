package com.bemos.data.local.shared_preferences.repository_impl

import android.content.Context
import androidx.core.content.edit
import com.bemos.shared.Constants.BOOLEAN_KEY
import com.bemos.shared.Constants.SHARED_PREF_BOOL
import com.bemos.city.shared_preferences_repo.LocationPreviewManagerRepository

class LocationPreviewManagerRepositoryImpl(
    private val context: Context
) : LocationPreviewManagerRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_BOOL, Context.MODE_PRIVATE)
    override fun setLocation(value: Boolean) {
        sharedPreferences.edit {
            putBoolean(BOOLEAN_KEY, value)
        }
    }

    override fun getLocation(): Boolean {
        val booleanValue = sharedPreferences.getBoolean(BOOLEAN_KEY, false)
        return booleanValue
    }
}