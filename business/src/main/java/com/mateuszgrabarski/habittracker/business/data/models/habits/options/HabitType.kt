package com.mateuszgrabarski.habittracker.business.data.models.habits.options

import androidx.annotation.StringRes
import com.mateuszgrabarski.habittracker.resources.R.string.habit_type_none
import com.mateuszgrabarski.habittracker.resources.R.string.habit_type_number
import com.mateuszgrabarski.habittracker.resources.R.string.habit_type_timer
import com.mateuszgrabarski.habittracker.resources.R.string.habit_type_yes_or_no
import com.mateuszgrabarski.habittracker.resources.ui.components.abstraction.ItemToSelect

enum class HabitType(
    @StringRes override val stringId: Int
) : ItemToSelect {
    None(habit_type_none),
    YesOrNo(habit_type_yes_or_no),
    Number(habit_type_number),
    Timer(habit_type_timer);

    companion object {
        fun getNotSelectableType() = None

        fun getSelectableTypes(): List<HabitType> =
            values().filter { it != getNotSelectableType() }

        fun fromIdToSelectedItem(stringId: Int): ItemToSelect? =
            values().find { it.stringId == stringId }
    }
}
