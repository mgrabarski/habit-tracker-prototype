package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.add.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.FilledHabitTypeInputs
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.NumberInputs

class NumberTypeInputsViewModel : ViewModel() {

    var unit by mutableStateOf("")
        private set

    var goal by mutableStateOf("")
        private set

    fun updateUnit(unit: String) {
        this.unit = unit
    }

    fun updateGoal(goal: String) {
        this.goal = goal
    }

    fun toFilledNumbers(): FilledHabitTypeInputs = NumberInputs(
        goal = goal.toDoubleOrNull() ?: 0.0,
        unit = unit
    )
}
