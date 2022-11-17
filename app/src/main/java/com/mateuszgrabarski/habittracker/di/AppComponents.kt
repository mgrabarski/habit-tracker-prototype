package com.mateuszgrabarski.habittracker.di

import com.mateuszgrabarski.habittracker.business.di.businessModules
import com.mateuszgrabarski.habittracker.features.habits.add.di.addHabitModule
import com.mateuszgrabarski.habittracker.framework.database.di.localDatabaseModule

val appModules = listOf(
    addHabitModule,
    localDatabaseModule
) + businessModules
