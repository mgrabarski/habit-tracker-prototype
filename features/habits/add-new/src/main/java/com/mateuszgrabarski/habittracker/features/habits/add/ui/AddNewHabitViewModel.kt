package com.mateuszgrabarski.habittracker.features.habits.add.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mateuszgrabarski.habittracker.business.habits.HabitType
import com.mateuszgrabarski.habittracker.features.habits.add.application.BaseHabitInfoValidator
import com.mateuszgrabarski.habittracker.features.habits.add.ui.model.FilledHabitTypeInputs
import com.mateuszgrabarski.habittracker.features.habits.add.ui.model.SelectedIcon

class AddNewHabitViewModel(
    private val nextButtonValidator: BaseHabitInfoValidator
) : ViewModel() {

    var selectedIcon by mutableStateOf<SelectedIcon?>(null)
        private set

    var nextButtonEnabled by mutableStateOf(false)
        private set

    var habitName by mutableStateOf("")
        private set

    var habitDescription by mutableStateOf("")
        private set

    var habitType by mutableStateOf(HabitType.getNotSelectableType())
        private set

    private var inputs by mutableStateOf<FilledHabitTypeInputs?>(null)

    fun updateSelectedIcon(
        icon: SelectedIcon
    ) {
        selectedIcon = icon
        enableNextButton()
    }

    fun updateHabitName(name: String) {
        habitName = name
        enableNextButton()
    }

    fun updateHabitDescription(description: String) {
        habitDescription = description
    }

    fun updateHabitType(type: HabitType) {
        habitType = type
        inputs = null
        enableNextButton()
    }

    fun updateHabitTypeInputs(inputs: FilledHabitTypeInputs) {
        this.inputs = inputs
    }

    private fun enableNextButton() {
        nextButtonEnabled = nextButtonValidator.isValid(
            selectedIcon = selectedIcon,
            habitName = habitName,
            habitType = habitType,
            inputs = inputs
        )
    }
}
