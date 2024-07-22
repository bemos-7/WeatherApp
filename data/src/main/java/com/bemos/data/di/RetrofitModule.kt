package com.bemos.data.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class RetrofitModule {

    companion object {
        private const val BASE_WEATHER_API_URL = "https://api.weatherapi.com/"
        private const val BASE_CITY_API_URL = "https://countriesnow.space/api/"
    }

    @Provides
    fun provideWeatherRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_WEATHER_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideWeatherApi(
        retrofit: Retrofit
    ) : com.bemos.data.remote.retrofit.weather.WeatherApi {
        return retrofit.create(com.bemos.data.remote.retrofit.weather.WeatherApi::class.java)
    }

    @Provides
    @Named("City")
    fun provideCityRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_CITY_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Named("City")
    fun provideCityApi(
       @Named("City") retrofit: Retrofit
    ) : com.bemos.data.remote.retrofit.city.CityApi {
        return retrofit.create(com.bemos.data.remote.retrofit.city.CityApi::class.java)
    }


}