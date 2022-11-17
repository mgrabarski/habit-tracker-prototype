package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.mateuszgrabarski.habittracker.business.habits.HabitDuration
import com.mateuszgrabarski.habittracker.business.habits.add.NewHabitBaseDefinition
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.AddNewHabitDurationScreenViewModel
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.uicomponents.DayInWeekCard
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.uicomponents.DaysInMonthCard
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.uicomponents.DurationTypeCard
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.uicomponents.StartEndDateCard
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_duration_save
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun AddNewHabitDurationScreen(
    habitBaseDefinition: NewHabitBaseDefinition
) {
    val viewModel = getViewModel<AddNewHabitDurationScreenViewModel> {
        parametersOf(habitBaseDefinition)
    }

    var showStartDateDialog by remember { mutableStateOf(false) }
    var showEndDateDialog by remember { mutableStateOf(false) }

    val startDateDialog = DatePickerDialog(
        LocalContext.current,
        { _, year, month, dayOfMonth ->
            showStartDateDialog = false
            viewModel.updateStartDate(
                year = year,
                month = month,
                dayOfMonth = dayOfMonth
            )
        },
        viewModel.startDate.year,
        viewModel.startDate.monthValue,
        viewModel.startDate.dayOfMonth
    )

    val endDateDialog = DatePickerDialog(
        LocalContext.current,
        { _, year, month, dayOfMonth ->
            showEndDateDialog = false
            viewModel.updateEndDate(
                year = year,
                month = month,
                dayOfMonth = dayOfMonth
            )
        },
        viewModel.endDate?.year ?: viewModel.startDate.year,
        viewModel.endDate?.monthValue ?: viewModel.startDate.monthValue,
        viewModel.endDate?.dayOfMonth ?: viewModel.startDate.dayOfMonth
    )

    if (showStartDateDialog) {
        startDateDialog.show()
    }

    if (showEndDateDialog) {
        endDateDialog.show()
    }

    Content(
        viewModel = viewModel,
        showStartDateDialog = {
            showStartDateDialog = true
        },
        showEndDateDialog = {
            showEndDateDialog = true
        }
    )
}

@Composable
private fun Content(
    viewModel: AddNewHabitDurationScreenViewModel,
    showStartDateDialog: () -> Unit,
    showEndDateDialog: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            StartEndDateCard(
                startDate = viewModel.startDate.displayValue,
                endDate = viewModel.endDate?.displayValue.orEmpty(),
                showStartDateDialog = showStartDateDialog,
                showEndDateDialog = showEndDateDialog
            )

            DurationTypeCard(
                selectedDuration = viewModel.selectedDuration,
                updateSelectedDuration = {
                    viewModel.updateSelectedDuration(duration = it)
                }
            )

            when (viewModel.selectedDuration) {
                HabitDuration.DaysInWeek -> DayInWeekCard(
                    weekDays = viewModel.weekDays,
                    updateSelectedWeekDay = {
                        viewModel.updateSelectedWeekDay(day = it)
                    }
                )
                HabitDuration.DaysInMonth -> DaysInMonthCard(
                    monthDays = viewModel.monthDays,
                    updateSelectedState = {
                        viewModel.updateSelectedMonthDay(day = it)
                    }
                )
                else -> Unit
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                enabled = viewModel.saveEnabled,
                onClick = {
                    viewModel.saveHabit {

                    }
                }
            ) {
                Text(text = stringResource(id = add_habit_duration_save))
            }
        }
    }
}
