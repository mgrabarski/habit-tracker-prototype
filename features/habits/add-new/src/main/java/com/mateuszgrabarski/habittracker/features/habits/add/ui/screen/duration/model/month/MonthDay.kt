package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.month

data class MonthDay(
    val dayNumber: Int,
    val selected: Boolean
) {

    fun reverse() = MonthDay(dayNumber = dayNumber, selected = selected.not())

    companion object {

        const val MAX_NUMBER_OF_DAYS = 31

        fun generateNotSelectedDays() =
            (1..MAX_NUMBER_OF_DAYS).map {
                MonthDay(
                    dayNumber = it,
                    selected = false
                )
            }
    }
}
