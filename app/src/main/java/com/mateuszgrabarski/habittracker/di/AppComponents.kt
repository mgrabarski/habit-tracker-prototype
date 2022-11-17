package com.mateuszgrabarski.habittracker.di

import com.mateuszgrabarski.habittracker.business.di.businessModule
import com.mateuszgrabarski.habittracker.features.habits.add.di.addHabitModule

val appModules = listOf(
    addHabitModule,
    businessModule
)
