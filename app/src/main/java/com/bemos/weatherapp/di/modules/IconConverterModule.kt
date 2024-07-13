package com.bemos.weatherapp.di.modules

import com.bemos.domain.repositories.IconConverterRepository
import com.bemos.weatherapp.icon_converter.IconConverterImpl
import dagger.Module
import dagger.Provides

@Module
class IconConverterModule {

    @Provides
    fun provideIconConverterRepository() : IconConverterRepository {
        return IconConverterImpl()
    }

}