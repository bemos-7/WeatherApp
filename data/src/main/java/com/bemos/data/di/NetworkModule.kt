package com.bemos.data.di

import android.content.Context
import com.bemos.data.remote.network.NetworkRepositoryImpl
import com.bemos.domain.repositories.NetworkRepository
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideNetworkRepository(
        context: Context
    ) : NetworkRepository {
        return NetworkRepositoryImpl(
            context = context
        )
    }

}