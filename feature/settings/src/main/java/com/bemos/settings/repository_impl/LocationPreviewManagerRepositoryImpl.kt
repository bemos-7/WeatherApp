package com.bemos.settings.repository_impl

import android.content.Context
import androidx.core.content.edit
import com.bemos.domain.repositories.LocationPreviewManagerRepository

private const val SHARED_PREF_BOOL = "sharedPrefBool"
private const val BOOLEAN_KEY = "booleanKey"
class LocationPreviewManagerRepositoryImpl(
    private val context: Context
) : LocationPreviewManagerRepository {
    override fun setLocation(value: Boolean) {
        val sharedPreferences = context.getSharedPreferences(SHARED_PREF_BOOL, Context.MODE_PRIVATE)
        sharedPreferences.edit {
            putBoolean(BOOLEAN_KEY, value)
        }
    }

    override fun getLocation(): Boolean {
        val sharedPreferences = context.getSharedPreferences(SHARED_PREF_BOOL, Context.MODE_PRIVATE)
        val booleanValue = sharedPreferences.getBoolean(BOOLEAN_KEY, false)
        return booleanValue
    }
}