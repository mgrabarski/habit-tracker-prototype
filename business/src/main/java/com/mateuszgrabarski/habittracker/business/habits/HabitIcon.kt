package com.mateuszgrabarski.habittracker.business.habits

import androidx.annotation.DrawableRes
import com.mateuszgrabarski.habittracker.resources.R

enum class HabitIcon(
    @DrawableRes val iconId: Int
) {
    Water(R.drawable.ic_add),
    Meditation(R.drawable.ic_habit_icon_meditation)
}
