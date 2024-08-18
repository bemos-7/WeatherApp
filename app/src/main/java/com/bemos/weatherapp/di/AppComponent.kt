package com.bemos.weatherapp.di

import android.content.Context
import com.bemos.weatherapp.app.App
import com.bemos.weatherapp.di.modules.AppModule
import com.bemos.data.di.DataModule
import com.bemos.domain.di.DomainModule
import com.bemos.data.di.RetrofitModule
import com.bemos.data.di.RoomModule
import com.bemos.home.di.HomeModule
import com.bemos.map.di.MapModule
import com.bemos.weather.di.NetworkModule
import com.bemos.weatherapp.di.modules.IconConverterModule
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
        IconConverterModule::class,
        HomeModule::class,
        NetworkModule::class,
        MapModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            context: Context,
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