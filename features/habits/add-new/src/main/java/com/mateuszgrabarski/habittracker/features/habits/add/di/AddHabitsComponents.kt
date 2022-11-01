package com.mateuszgrabarski.habittracker.features.habits.add.di

import com.mateuszgrabarski.habittracker.features.habits.add.application.BaseHabitInfoValidator
import com.mateuszgrabarski.habittracker.features.habits.add.ui.AddNewHabitViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val addHabitModule = module {
    viewModel { AddNewHabitViewModel(get()) }

    factory { BaseHabitInfoValidator() }
}
