package com.maddukuri.republicservices

import ApplicationComponent
import android.app.Application

class MainApplication : Application() {

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}