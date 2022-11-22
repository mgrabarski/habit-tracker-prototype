package com.mateuszgrabarski.habittracker.framework.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitType
import com.mateuszgrabarski.habittracker.business.data.types.Id
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabit
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabitTypeDetails
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabitTypeDetails.Columns
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabitTypeDetails.ForeignKeys
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabitTypeDetails.Indexes
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabitTypeDetails.Prefix

@Entity(
    tableName = TableHabitTypeDetails.TableName,
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
        Index(value = [Indexes.HabitId]),
    ]
)
data class HabitTypeDetailsEntity(
    @PrimaryKey
    @ColumnInfo(name = Columns.Id)
    val id: Id,

    @ColumnInfo(name = Columns.Type)
    val type: HabitType,

    @Embedded(prefix = Prefix.Number)
    val numberData: NumberDataEntity?,

    @Embedded(prefix = Prefix.Time)
    val timeData: TimeDataEntity?,

    @ColumnInfo(name = ForeignKeys.HabitId)
    val habitId: Id
)

data class NumberDataEntity(
    @ColumnInfo(name = Columns.NumberGoal)
    val goal: Double,

    @ColumnInfo(name = Columns.NumberUnit)
    val unit: String
)

data class TimeDataEntity(
    val hours: Int,
    val minutes: Int
)
