package com.bemos.data.di

import com.bemos.city.repository.CityApi
import com.bemos.core.Constants.ANNOTATION_NAME_CITY
import com.bemos.core.Constants.BASE_CITY_API_URL
import com.bemos.core.Constants.BASE_WEATHER_API_URL
import com.bemos.weather.repository.WeatherApi
import dagger.Module
import dagger.Provides
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
    ) : WeatherApi {
        return retrofit.create(WeatherApi::class.java)
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
    ) : CityApi {
        return retrofit.create(CityApi::class.java)
    }


}