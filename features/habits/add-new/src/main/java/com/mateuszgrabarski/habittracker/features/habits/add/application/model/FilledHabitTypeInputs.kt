package com.mateuszgrabarski.habittracker.features.habits.add.application.model

import com.mateuszgrabarski.habittracker.business.habits.add.InputDescription
import com.mateuszgrabarski.habittracker.business.habits.add.InputDescription.Number
import com.mateuszgrabarski.habittracker.business.habits.add.InputDescription.Time

sealed class FilledHabitTypeInputs {
    abstract fun toInputDescription(): InputDescription
}

data class NumberInputs(
    val goal: Double,
    val unit: String
) : FilledHabitTypeInputs() {

    override fun toInputDescription(): InputDescription = Number(
        goal = goal,
        unit = unit
    )
}

data class TimeInputs(
    val time: SelectedTime
) : FilledHabitTypeInputs() {

    override fun toInputDescription(): InputDescription = Time(
        hours = time.hours,
        minutes = time.minutes
    )
}
