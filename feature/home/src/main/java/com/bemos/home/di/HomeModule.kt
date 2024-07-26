package com.bemos.home.di

import android.app.Activity
import android.content.Context
import com.bemos.domain.repositories.CurrentLocationRepository
import com.bemos.home.repositroy_impl.CurrentLocationRepositoryImpl
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun provideCurrentLocationRepository(
        fusedLocationProviderClient: FusedLocationProviderClient,
        context: Context,
    ) : CurrentLocationRepository {
        return CurrentLocationRepositoryImpl(
            fusedLocationProviderClient = fusedLocationProviderClient,
            context = context
        )
    }

}