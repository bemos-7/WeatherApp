package com.bemos.settings.di

import android.content.Context
import com.bemos.domain.repositories.LocationManagerRepository
import com.bemos.domain.repositories.LocationPreviewManagerRepository
import com.bemos.settings.repository_impl.LocationManagerRepositoryImpl
import com.bemos.settings.repository_impl.LocationPreviewManagerRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class SettingsModule {

    @Provides
    fun provideLocationManagerRepository(context: Context): LocationManagerRepository {
        return LocationManagerRepositoryImpl(context)
    }

    @Provides
    fun provideLocationPreviewManagerRepository(context: Context): LocationPreviewManagerRepository {
        return LocationPreviewManagerRepositoryImpl(context)
    }
}