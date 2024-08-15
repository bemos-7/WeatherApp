package com.bemos.weatherapp.app

import android.app.Application
import com.bemos.weatherapp.di.AppComponent
import com.bemos.weatherapp.di.DaggerAppComponent
import com.google.firebase.Firebase
import com.google.firebase.initialize

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        Firebase.initialize(this)

        appComponent = DaggerAppComponent.factory()
            .create(context = this)
    }

}