package com.mateuszgrabarski.habittracker.features.habits.add.ui.dialog.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitIcon
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.SelectedIcon

class ChooseHabitIconDialogViewModel : ViewModel() {

    var selectedIcon by mutableStateOf<HabitIcon?>(null)
        private set

    var selectedColor by mutableStateOf(0)
        private set

    fun updateSelectedIcon(icon: HabitIcon) {
        selectedIcon = icon
    }

    fun updateSelectedColor(color: Int) {
        selectedColor = color
    }

    fun toSelectedIcon() = SelectedIcon(
        icon = requireNotNull(selectedIcon),
        color = selectedColor
    )

    fun reset() {
        selectedIcon = null
        selectedColor = 0
    }
}
