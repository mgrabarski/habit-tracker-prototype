package com.mateuszgrabarski.habittracker.framework.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabit
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabitDuration
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabitTypeDetails
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitDurationEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitTypeDetailsEntity

internal data class HabitAndDetailsRelation(
    @Embedded val habit: HabitEntity,
    @Relation(
        parentColumn = TableHabit.Columns.Id,
        entityColumn = TableHabitTypeDetails.ForeignKeys.HabitId
    )
    val typeDetails: HabitTypeDetailsEntity,
    @Relation(
        parentColumn = TableHabit.Columns.Id,
        entityColumn = TableHabitDuration.ForeignKeys.HabitId
    )
    val duration: HabitDurationEntity
)
