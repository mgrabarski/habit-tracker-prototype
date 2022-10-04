package com.mateuszgrabarski.habittracker

import android.app.Application
import com.mateuszgrabarski.habittracker.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HabitTrackerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    private fun configureDi() = startKoin {
        androidContext(this@HabitTrackerApplication)
        modules(appModules)
    }
}
