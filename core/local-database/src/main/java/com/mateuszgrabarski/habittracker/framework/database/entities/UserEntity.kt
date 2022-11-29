package com.mateuszgrabarski.habittracker.framework.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.mateuszgrabarski.habittracker.business.data.types.Id
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableUser
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableUser.Columns
import com.mateuszgrabarski.habittracker.framework.database.Tables.TableUser.Indexes
import java.time.LocalDateTime

@Entity(
    tableName = TableUser.TableName,
    indices = [
        Index(value = [Indexes.Id])
    ]
)
internal data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = Columns.Id)
    val id: Id,
    @ColumnInfo(name = Columns.CreateDate)
    val createDate: LocalDateTime
)
