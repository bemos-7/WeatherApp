package com.bemos.weather.di

import com.bemos.weather.interceptor.ApiKeyInterceptor
import com.bemos.weather.interceptor.fetchApiKey
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClient(
        apiKeyInterceptor: ApiKeyInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .build()
    }

    @Provides
    fun provideApiKeyInterceptor(): ApiKeyInterceptor {
        return ApiKeyInterceptor(::fetchApiKey)
    }

}