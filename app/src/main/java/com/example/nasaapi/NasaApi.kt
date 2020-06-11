package com.example.nasaapi

import android.app.Application
import com.example.nasaapi.di.appModule
import com.example.nasaapi.di.networkModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class NasaApi : Application() {

    val defaultCurrentActivityListener : DefaultCurrentActivityListener by inject()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@NasaApi)
            modules(listOf(networkModule, appModule))
        }
        registerActivityLifecycleCallbacks(defaultCurrentActivityListener)
    }
}