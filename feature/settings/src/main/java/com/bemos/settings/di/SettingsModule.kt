package com.bemos.settings.di

import android.content.Context
import com.bemos.domain.repositories.LocationManagerRepository
import com.bemos.settings.repository_impl.LocationManagerRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class SettingsModule {

    @Provides
    fun provideLocationManagerRepository(context: Context): LocationManagerRepository {
        return LocationManagerRepositoryImpl(context)
    }

}