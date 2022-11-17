package com.mateuszgrabarski.habittracker.business.data.models.habits.options

import androidx.annotation.StringRes
import com.mateuszgrabarski.habittracker.resources.R
import com.mateuszgrabarski.habittracker.resources.ui.components.abstraction.ItemToSelect

enum class HabitDuration(
    @StringRes override val stringId: Int
) : ItemToSelect {

    EveryDay(R.string.habit_duration_every_day),
    DaysInWeek(R.string.habit_duration_week_days),
    DaysInMonth(R.string.habit_duration_month_days);

    companion object {
        fun getDefaultDuration() = EveryDay

        fun getSelectableTypes(): List<HabitDuration> = values().toList()
    }
}
