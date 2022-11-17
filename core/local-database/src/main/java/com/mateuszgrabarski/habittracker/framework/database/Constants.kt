package com.mateuszgrabarski.habittracker.framework.database

internal const val DatabaseDiScope = "DATABASE"

internal const val DATABASE_NAME = "habit.db"
internal const val DATABASE_VERSION = 1

internal object Tables {

    object TableUser {
        const val TableName = "user"

        object Columns {
            const val CreateDate = "created_ts"
        }
    }
}
