package com.example.nasaapi.di

import com.example.nasaapi.ActivityRetrivier
import com.example.nasaapi.DefaultCurrentActivityListener
import org.koin.dsl.module

val appModule = module {
    single { DefaultCurrentActivityListener() }
    single { ActivityRetrivier(get()) }
}