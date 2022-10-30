package com.mateuszgrabarski.habittracker.features.habits.add.application

import com.mateuszgrabarski.habittracker.business.habits.HabitType
import com.mateuszgrabarski.habittracker.features.habits.add.ui.model.SelectedIcon

class BaseHabitInfoValidator {

    fun isValid(
        selectedIcon: SelectedIcon?,
        habitName: String,
        habitType: HabitType
    ): Boolean =
        iconMustBeSelected(selectedIcon = selectedIcon) &&
            habitNameMustBeLongerThenMinNumberOfChars(habitName = habitName) &&
            typeCanNotBeNotSelected(habitType = habitType)

    private fun iconMustBeSelected(selectedIcon: SelectedIcon?) =
        selectedIcon != null

    private fun habitNameMustBeLongerThenMinNumberOfChars(habitName: String) =
        habitName.length > MIN_NUMBER_OF_CHARS

    private fun typeCanNotBeNotSelected(habitType: HabitType) =
        habitType != HabitType.getNotSelectableType()

    companion object {

        private const val MIN_NUMBER_OF_CHARS = 3
    }
}
