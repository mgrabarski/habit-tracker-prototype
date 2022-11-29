package com.mateuszgrabarski.habittracker.framework.database.application.impl

import com.mateuszgrabarski.habittracker.framework.database.application.LocalTimeProvider
import java.time.LocalDateTime
import java.time.ZoneOffset

internal class LocalTimeProviderImpl(
    private val zone: ZoneOffset
) : LocalTimeProvider {

    override fun now(): LocalDateTime = LocalDateTime.now(zone)
}
