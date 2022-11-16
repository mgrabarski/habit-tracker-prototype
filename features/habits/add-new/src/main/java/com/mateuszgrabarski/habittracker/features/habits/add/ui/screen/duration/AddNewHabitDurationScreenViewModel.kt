package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mateuszgrabarski.habittracker.business.habits.HabitDuration
import com.mateuszgrabarski.habittracker.business.habits.add.NewHabitBaseDefinition
import com.mateuszgrabarski.habittracker.features.habits.add.application.DurationValidator
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.SelectedDate
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.month.MonthDay
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.month.MonthSelectedDays
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.week.WeekDay
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.week.WeekSelectedDays
import java.time.LocalDate

class AddNewHabitDurationScreenViewModel(
    private val habitBaseDefinition: NewHabitBaseDefinition,
    today: LocalDate,
    private val selectedDays: MonthSelectedDays,
    private val daysSelected: WeekSelectedDays,
    private val validator: DurationValidator
) : ViewModel() {

    var selectedDuration by mutableStateOf(HabitDuration.getDefaultDuration())
        private set

    var monthDays = mutableStateListOf<MonthDay>().apply {
        addAll(selectedDays.selectedDays)
    }
        private set

    var weekDays = mutableStateListOf<WeekDay>().apply {
        addAll(daysSelected.selectedDays)
    }
        private set

    var startDate by mutableStateOf(SelectedDate.from(date = today))
        private set

    var endDate by mutableStateOf<SelectedDate?>(null)
        private set

    var saveEnabled by mutableStateOf(true)
        private set

    fun updateSelectedState(day: MonthDay) {
        selectedDays.updateSelectedState(day = day)
        monthDays.apply {
            clear()
            addAll(selectedDays.selectedDays)
        }
        validate()
    }

    fun updateSelectedWeekDay(day: WeekDay) {
        daysSelected.updateSelectedState(day = day)
        weekDays.apply {
            clear()
            addAll(daysSelected.selectedDays)
        }
        validate()
    }

    fun updateSelectedDuration(duration: HabitDuration) {
        selectedDuration = duration
        validate()
    }

    fun updateStartDate(year: Int, month: Int, dayOfMonth: Int) {
        startDate = SelectedDate(
            year = year,
            month = month + 1,
            dayOfMonth = dayOfMonth
        )
        validate()
    }

    fun updateEndDate(year: Int, month: Int, dayOfMonth: Int) {
        endDate = SelectedDate(
            year = year,
            month = month + 1,
            dayOfMonth = dayOfMonth
        )
        validate()
    }

    fun saveHabit(onComplete: () -> Unit) {
        onComplete()
    }

    private fun validate() {
        saveEnabled = validator.validate(
            type = selectedDuration,
            weekDays = weekDays,
            monthDays = monthDays
        )
    }
}
