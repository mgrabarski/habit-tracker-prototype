package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.week

data class WeekSelectedDays(
    private val days: MutableList<WeekDay> = WeekDay.generateNotSelectedWeekDays().toMutableList()
) {

    val selectedDays: List<WeekDay>
        get() = days

    fun updateSelectedState(day: WeekDay) {
        val index = days.indexOf(day)
        if (index >= 0) {
            days.set(
                index = index,
                element = day.reverse()
            )
        }
    }

    fun toDataDays(): List<Int> = days.filter { it.selected }.map { it.day.number }
}
