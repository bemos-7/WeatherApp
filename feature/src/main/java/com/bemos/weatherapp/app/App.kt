package com.bemos.weatherapp.app

import android.app.Application
import com.bemos.weatherapp.di.AppComponent
import com.bemos.weatherapp.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory()
            .create(context = this)
    }

}