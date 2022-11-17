package com.mateuszgrabarski.habittracker.di

import com.mateuszgrabarski.habittracker.business.di.businessModules
import com.mateuszgrabarski.habittracker.features.habits.add.di.addHabitModule

val appModules = listOf(
    addHabitModule
) + businessModules
