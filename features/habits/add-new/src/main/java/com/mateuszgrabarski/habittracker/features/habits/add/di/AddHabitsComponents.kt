package com.mateuszgrabarski.habittracker.features.habits.add.di

import com.mateuszgrabarski.habittracker.features.habits.add.application.BaseHabitInfoValidator
import com.mateuszgrabarski.habittracker.features.habits.add.ui.AddNewHabitViewModel
import com.mateuszgrabarski.habittracker.features.habits.add.ui.dialog.ChooseHabitIconDialogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val addHabitModule = module {
    viewModel { AddNewHabitViewModel(get()) }
    viewModel { ChooseHabitIconDialogViewModel() }

    factory { BaseHabitInfoValidator() }
}
