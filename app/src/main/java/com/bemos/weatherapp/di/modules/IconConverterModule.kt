package com.bemos.weatherapp.di.modules

import com.bemos.domain.repositories.IconConverterRepository
import com.bemos.feature.ui.IconConverterImpl
import dagger.Module
import dagger.Provides

@Module
class IconConverterModule {

    @Provides
    fun provideIconConverterRepository() : IconConverterRepository {
        return IconConverterImpl()
    }

}