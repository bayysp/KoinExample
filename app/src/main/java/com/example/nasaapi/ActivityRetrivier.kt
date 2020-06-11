package com.example.nasaapi

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater

//is use to get instance of the current activity which using koin context injection
class ActivityRetrivier(val defaultCurrentActivityListener : DefaultCurrentActivityListener){
    val layoutInfalter : LayoutInflater =
        LayoutInflater.from(defaultCurrentActivityListener.currentActivity)

    val context : Context = defaultCurrentActivityListener.context

    fun getActivity() : Activity? {
        return defaultCurrentActivityListener.currentActivity
    }
}