package com.mateuszgrabarski.habittracker.framework.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitDuration
import com.mateuszgrabarski.habittracker.business.data.types.Id
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabit
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabitDuration
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabitDuration.Columns
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabitDuration.ForeignKeys
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabitDuration.Indexes
import java.time.DayOfWeek
import java.time.LocalDate

@Entity(
    tableName = TableHabitDuration.TableName,
    foreignKeys = [
        ForeignKey(
            entity = HabitEntity::class,
            parentColumns = arrayOf(TableHabit.Columns.Id),
            childColumns = arrayOf(ForeignKeys.HabitId),
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = [Indexes.Id]),
        Index(value = [Indexes.HabitId])
    ]
)
internal data class HabitDurationEntity(
    @PrimaryKey
    @ColumnInfo(name = Columns.Id)
    val id: Id,

    @ColumnInfo(name = Columns.StartDate)
    val startDate: LocalDate,

    @ColumnInfo(name = Columns.EndDate)
    val endDate: LocalDate?,

    @ColumnInfo(name = Columns.Duration)
    val duration: HabitDuration,

    @ColumnInfo(name = Columns.WeekDays)
    val weekDays: List<DayOfWeek>,

    @ColumnInfo(name = Columns.MonthDays)
    val monthDays: List<Int>,

    @ColumnInfo(name = ForeignKeys.HabitId)
    val habitId: Id
)
