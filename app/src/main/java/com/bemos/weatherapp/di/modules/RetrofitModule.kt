package com.bemos.weatherapp.di.modules

import com.bemos.weatherapp.data.remote.retrofit.WeatherApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class RetrofitModule {

    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideWeatherApi(
        retrofit: Retrofit
    ) : WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }

}