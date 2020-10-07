package com.cube.googleplay.examples

import android.app.Application
import com.cube.googleplay.examples.di.DependenciesManager

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        DependenciesManager.init(this)
    }
}