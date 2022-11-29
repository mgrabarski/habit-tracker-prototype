package com.mateuszgrabarski.habittracker.di

import com.mateuszgrabarski.habittracker.business.di.businessModules
import com.mateuszgrabarski.habittracker.features.habits.add.di.addHabitModule
import com.mateuszgrabarski.habittracker.features.splash.di.splashScreenModule
import com.mateuszgrabarski.habittracker.framework.database.di.localDatabaseModule
import com.mateuszgrabarski.habittracker.framework.storage.di.storageModule

val appModules = listOf(
    addHabitModule,
    localDatabaseModule,
    splashScreenModule,
    storageModule
) + businessModules
