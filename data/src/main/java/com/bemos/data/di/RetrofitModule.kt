package com.bemos.data.di

import com.bemos.city.repository.CityApi
import com.bemos.shared.Constants.ANNOTATION_NAME_CITY
import com.bemos.shared.Constants.BASE_CITY_API_URL
import com.bemos.shared.Constants.BASE_WEATHER_API_URL
import com.bemos.weather.interceptor.ApiKeyInterceptor
import com.bemos.weather.interceptor.fetchApiKey
import com.bemos.weather.repository.WeatherApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class RetrofitModule {

    val apiKeyInterceptor = ApiKeyInterceptor(::fetchApiKey)
    @Provides
    fun provideWeatherRetrofit(
        okHttpClient: OkHttpClient
    ) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_WEATHER_API_URL)
            .client(okHttpClient)
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