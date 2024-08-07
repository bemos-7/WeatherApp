package com.bemos.weatherapp.di

import android.content.Context
import com.bemos.weatherapp.app.App
import com.bemos.weatherapp.di.modules.AppModule
import com.bemos.data.di.DataModule
import com.bemos.domain.di.DomainModule
import com.bemos.data.di.NetworkModule
import com.bemos.data.di.RetrofitModule
import com.bemos.data.di.RoomModule
import com.bemos.home.di.HomeModule
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
        NetworkModule::class,
        IconConverterModule::class,
        HomeModule::class,
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