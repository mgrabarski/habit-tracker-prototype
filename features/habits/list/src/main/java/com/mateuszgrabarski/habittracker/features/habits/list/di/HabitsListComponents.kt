package com.mateuszgrabarski.habittracker.features.habits.list.di

import com.mateuszgrabarski.habittracker.features.habits.list.ui.screens.HabitsListScreenViewModel
import com.mateuszgrabarski.habittracker.features.habits.list.ui.screens.LoadHabitsList
import com.mateuszgrabarski.habittracker.features.habits.list.ui.screens.LoadHabitsListImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val habitsListModule = module {
    factory<LoadHabitsList> { LoadHabitsListImpl(get()) }

    viewModel { HabitsListScreenViewModel(get()) }
}
