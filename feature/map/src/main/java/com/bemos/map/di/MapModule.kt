package com.bemos.map.di


import android.content.Context
import com.bemos.feature.service.map.MapRepository
import com.bemos.feature.service.map.MapRepositoryImpl
import com.bemos.map.vm.MapScreenViewModelFactory
import dagger.Module
import dagger.Provides
import org.osmdroid.views.MapView

@Module
class MapModule {

    @Provides
    fun provideMapScreenViewModelFactory(
        mapRepository: MapRepository
    ): MapScreenViewModelFactory {
        return MapScreenViewModelFactory(
            mapRepository = mapRepository
        )
    }

    @Provides
    fun provideMapRepository(
        context: Context
    ): MapRepository {
        return MapRepositoryImpl(
            context = context
        )
    }

}