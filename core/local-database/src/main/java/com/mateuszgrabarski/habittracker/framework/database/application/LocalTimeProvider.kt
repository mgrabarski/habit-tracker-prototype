package com.mateuszgrabarski.habittracker.framework.database.application

import java.time.LocalDateTime

internal interface LocalTimeProvider {
    fun now(): LocalDateTime
}
