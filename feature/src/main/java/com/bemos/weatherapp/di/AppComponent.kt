package com.bemos.weatherapp.di

import android.content.Context
import com.bemos.weatherapp.app.App
import com.bemos.weatherapp.di.modules.AppModule
import com.bemos.weatherapp.di.modules.DataModule
import com.bemos.weatherapp.di.modules.DomainModule
import com.bemos.weatherapp.di.modules.NetworkModule
import com.bemos.weatherapp.di.modules.RetrofitModule
import com.bemos.weatherapp.di.modules.RoomModule
import com.bemos.weatherapp.presentation.screen.main_activity.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        RoomModule::class,
        RetrofitModule::class,
        DomainModule::class,
        DataModule::class,
        AppModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            context: Context
        ): AppComponent

    }

}

val Context.appComponent : AppComponent get() {
    return if (this is App) {
        appComponent
    } else {
        applicationContext.appComponent
    }
}