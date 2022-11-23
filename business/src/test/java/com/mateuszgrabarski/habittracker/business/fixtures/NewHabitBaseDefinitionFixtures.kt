package com.mateuszgrabarski.habittracker.business.fixtures

import com.mateuszgrabarski.habittracker.business.data.models.habits.add.IconInfo
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.InputDescription
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.NewHabitBaseDefinition
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitIcon
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitType

object NewHabitBaseDefinitionFixtures {

    fun any() = NewHabitBaseDefinition(
        icon = IconInfo(
            icon = HabitIcon.Water,
            color = 0
        ),
        name = "some name",
        description = "some desc",
        type = HabitType.YesOrNo,
        inputs = InputDescription.NotNeeded
    )
}
