package com.mateuszgrabarski.habittracker.features.habits.add.di

import com.mateuszgrabarski.habittracker.features.habits.add.application.BaseHabitInfoValidator
import com.mateuszgrabarski.habittracker.features.habits.add.application.DurationValidator
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.base.viewmodel.AddNewHabitViewModel
import com.mateuszgrabarski.habittracker.features.habits.add.ui.dialog.viewmodels.ChooseHabitIconDialogViewModel
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.base.viewmodel.NumberTypeInputsViewModel
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.AddNewHabitDurationScreenViewModel
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.month.MonthSelectedDays
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.week.WeekSelectedDays
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.time.LocalDate

val addHabitModule = module {
    viewModel { AddNewHabitViewModel(get()) }
    viewModel { ChooseHabitIconDialogViewModel() }
    viewModel { NumberTypeInputsViewModel() }
    viewModel {
        AddNewHabitDurationScreenViewModel(
            habitBaseDefinition = get(),
            today = LocalDate.now(),
            selectedDays = MonthSelectedDays(),
            daysSelected = WeekSelectedDays(),
            validator = get()
        )
    }

    factory { BaseHabitInfoValidator() }
    factory { DurationValidator() }
}
