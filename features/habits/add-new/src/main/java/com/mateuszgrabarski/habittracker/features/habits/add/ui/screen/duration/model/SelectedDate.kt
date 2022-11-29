package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model

import java.time.LocalDate

data class SelectedDate(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int
) {
    fun toDate(): LocalDate = LocalDate.of(year, month, dayOfMonth)

    val monthValue: Int
        get() = month - 1

    val displayValue: String
        get() = "$dayOfMonth-$month-$year"

    companion object {

        fun from(date: LocalDate) = SelectedDate(
            year = date.year,
            month = date.monthValue,
            dayOfMonth = date.dayOfMonth
        )
    }
}
