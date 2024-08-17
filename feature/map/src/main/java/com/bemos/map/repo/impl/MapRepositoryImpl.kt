package com.bemos.map.repo.impl

import android.content.Context
import com.bemos.map.repo.MapRepository
import com.bemos.shared.Constants.MAP_SHARED_PREFERENCES
import org.osmdroid.config.Configuration

class MapRepositoryImpl(
    private val context: Context
) : MapRepository {

    private val sharedPreferences = context.getSharedPreferences(MAP_SHARED_PREFERENCES, Context.MODE_PRIVATE)

    override fun mapConfiguration() {
        Configuration.getInstance().load(context, sharedPreferences)
    }

}