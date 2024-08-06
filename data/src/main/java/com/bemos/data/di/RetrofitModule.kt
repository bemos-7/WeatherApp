package com.bemos.data.di

import com.bemos.core.Constants.ANNOTATION_NAME_CITY
import com.bemos.core.Constants.BASE_CITY_API_URL
import com.bemos.core.Constants.BASE_WEATHER_API_URL
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class RetrofitModule {

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
    @Named(ANNOTATION_NAME_CITY)
    fun provideCityRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_CITY_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Named(ANNOTATION_NAME_CITY)
    fun provideCityApi(
       @Named(ANNOTATION_NAME_CITY) retrofit: Retrofit
    ) : com.bemos.data.remote.retrofit.city.CityApi {
        return retrofit.create(com.bemos.data.remote.retrofit.city.CityApi::class.java)
    }


}