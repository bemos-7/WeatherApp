package com.bemos.weatherapp.di.modules

import com.bemos.weatherapp.data.remote.retrofit.city.CityApi
import com.bemos.weatherapp.data.remote.retrofit.weather.WeatherApi
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named

@Module
class RetrofitModule {

    @Provides
    fun provideWeatherRetrofit() : Retrofit {
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

    @Provides
    @Named("City")
    fun provideCityRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://countriesnow.space/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Named("City")
    fun provideCityApi(
       @Named("City") retrofit: Retrofit
    ) : CityApi {
        return retrofit.create(CityApi::class.java)
    }


}