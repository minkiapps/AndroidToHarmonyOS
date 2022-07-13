package com.minkiapps.android.example

import android.app.Application
import com.minkiapps.android.example.di.component.AppComponent
import com.minkiapps.android.example.di.component.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
    }
}