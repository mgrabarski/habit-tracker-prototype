package com.mateuszgrabarski.habittracker.business.data.models.habits.options

import androidx.annotation.DrawableRes
import com.mateuszgrabarski.habittracker.resources.R

enum class HabitIcon(
    @DrawableRes val iconId: Int
) {
    Water(R.drawable.ic_habit_icon_water),
    Meditation(R.drawable.ic_habit_icon_meditation),
    Book(R.drawable.ic_habit_icon_book),
    Coffee(R.drawable.ic_habit_icon_coffee),
    Sugar(R.drawable.ic_habit_icon_sugar),
    Dumbbell(R.drawable.ic_habit_icon_dumbbell),
    Todo(R.drawable.ic_habit_icon_todo),
    Fruit(R.drawable.ic_habit_icon_fruit),
    Notebook(R.drawable.ic_habit_icon_notebook),
    Pill(R.drawable.ic_habit_icon_pill),
    Run(R.drawable.ic_habit_icon_run),
    School(R.drawable.ic_habit_icon_school),
    Shower(R.drawable.ic_habit_icon_shower),
    Sleep(R.drawable.ic_habit_icon_sleep),
    Swim(R.drawable.ic_habit_icon_swim),
    Walk(R.drawable.ic_habit_icon_walk)
}
