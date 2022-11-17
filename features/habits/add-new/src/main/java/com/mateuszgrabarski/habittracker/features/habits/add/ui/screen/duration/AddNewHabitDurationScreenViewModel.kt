package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.HabitDurationDefinition
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.NewHabitBaseDefinition
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitDuration
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseResult
import com.mateuszgrabarski.habittracker.business.usecases.habit.add.StoreHabit
import com.mateuszgrabarski.habittracker.features.habits.add.application.DurationValidator
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.SelectedDate
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.month.MonthDay
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.month.MonthSelectedDays
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.week.WeekDay
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.week.WeekSelectedDays
import com.mateuszgrabarski.habittracker.resources.ui.components.ProcessingState
import kotlinx.coroutines.launch
import java.time.LocalDate

class AddNewHabitDurationScreenViewModel(
    private val habitBaseDefinition: NewHabitBaseDefinition,
    today: LocalDate,
    private val selectedMonthDays: MonthSelectedDays,
    private val selectedWeekDays: WeekSelectedDays,
    private val validator: DurationValidator,
    private val storeHabit: StoreHabit
) : ViewModel() {

    var selectedDuration by mutableStateOf(HabitDuration.getDefaultDuration())
        private set

    var monthDays = mutableStateListOf<MonthDay>().apply {
        addAll(selectedMonthDays.selectedDays)
    }
        private set

    var weekDays = mutableStateListOf<WeekDay>().apply {
        addAll(selectedWeekDays.selectedDays)
    }
        private set

    var startDate by mutableStateOf(SelectedDate.from(date = today))
        private set

    var endDate by mutableStateOf<SelectedDate?>(null)
        private set

    var saveEnabled by mutableStateOf(true)
        private set

    var processingState by mutableStateOf(ProcessingState.Idle)
        private set

    fun updateSelectedMonthDay(day: MonthDay) {
        selectedMonthDays.updateSelectedState(day = day)
        monthDays.apply {
            clear()
            addAll(selectedMonthDays.selectedDays)
        }
        validate()
    }

    fun updateSelectedWeekDay(day: WeekDay) {
        selectedWeekDays.updateSelectedState(day = day)
        weekDays.apply {
            clear()
            addAll(selectedWeekDays.selectedDays)
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
        processingState = ProcessingState.Processing
        viewModelScope.launch {
            storeHabit.store(
                baseDefinition = habitBaseDefinition,
                durationDefinition = HabitDurationDefinition(
                    startDate = startDate.toDate(),
                    endDate?.toDate(),
                    duration = selectedDuration,
                    weekDays = selectedMonthDays.toDataDays(),
                    monthDays = selectedWeekDays.toDataDays()
                )
            ).collect {
                processingState = ProcessingState.Idle
                when (it) {
                    is UseCaseResult.Success -> onComplete()
                    is UseCaseResult.GenericError -> {
                        // TODO: show toast with error
                    }
                }
            }
        }
    }

    private fun validate() {
        saveEnabled = validator.validate(
            type = selectedDuration,
            weekDays = weekDays,
            monthDays = monthDays
        )
    }
}
