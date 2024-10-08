package com.bemos.weather.interceptor

import android.content.res.Configuration
import android.content.res.Resources
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(
    private val fetchApiKey: (callback: (String?) -> Unit) -> Unit
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        var apiKey: String? = null
        val lang = localization()

        val latch = java.util.concurrent.CountDownLatch(1)

        fetchApiKey { token ->
            apiKey = token
            latch.countDown()
        }
        latch.await()

        if (apiKey.isNullOrEmpty()) {
            return chain.proceed(original)
        }

        val url = original.url().newBuilder().addQueryParameter("lang", lang).addQueryParameter("key", apiKey).build()
        original = original.newBuilder().url(url).build()
        return chain.proceed(original)
    }

    fun localization(): String {
        val config = Resources.getSystem().configuration
        val locale = config.locales.get(0)
        return locale.language
    }
}