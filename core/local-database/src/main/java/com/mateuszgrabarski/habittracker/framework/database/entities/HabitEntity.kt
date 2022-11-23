package com.mateuszgrabarski.habittracker.framework.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitIcon
import com.mateuszgrabarski.habittracker.business.data.types.Id
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabit
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabit.Columns
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabit.ForeignKeys
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabit.Indexes
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableHabit.Prefix
import java.time.LocalDateTime

@Entity(
    tableName = TableHabit.TableName,
    indices = [
        Index(value = [Indexes.Id]),
        Index(value = [Indexes.UserId])
    ]
)
internal data class HabitEntity(
    @PrimaryKey
    @ColumnInfo(name = Columns.Id)
    val id: Id,

    @ColumnInfo(name = Columns.Name)
    val name: String,

    @ColumnInfo(name = Columns.Description)
    val description: String,

    @Embedded(prefix = Prefix.IconPrefix)
    val icon: HabitIconEntity,

    @ColumnInfo(name = Columns.CreateTime)
    val createDate: LocalDateTime,

    @ColumnInfo(name = Columns.Archived)
    val archived: Boolean,

    @ColumnInfo(name = ForeignKeys.UserId)
    val userId: Id
)

internal data class HabitIconEntity(
    @ColumnInfo(name = Columns.IconImage)
    val image: HabitIcon,

    @ColumnInfo(name = Columns.IconColor)
    val color: Int
)
