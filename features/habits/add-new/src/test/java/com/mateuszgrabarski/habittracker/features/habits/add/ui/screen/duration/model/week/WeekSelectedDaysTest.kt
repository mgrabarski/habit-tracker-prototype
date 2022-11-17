package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.week

import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.Day
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.time.DayOfWeek

class WeekSelectedDaysTest : DescribeSpec({

    describe("default") {

        it("contains not selected week days") {
            WeekSelectedDays().selectedDays shouldBe WeekDay.generateNotSelectedWeekDays()
        }
    }

    describe("custom input") {

        it("should be same as in constructor") {
            val weekDay = WeekDay(day = Day(day = DayOfWeek.MONDAY), selected = false)

            WeekSelectedDays(
                days = mutableListOf(weekDay)
            ).selectedDays shouldBe listOf(weekDay)
        }
    }

    describe("update selected state of day") {

        it("to selected") {
            val day = WeekDay(day = Day(day = DayOfWeek.MONDAY), selected = false)

            WeekSelectedDays(
                days = mutableListOf(day)
            ).run {
                updateSelectedState(day)

                selectedDays.first() shouldBe WeekDay(
                    day = Day(day = DayOfWeek.MONDAY),
                    selected = true
                )
            }
        }

        it("to not selected") {
            val day = WeekDay(day = Day(day = DayOfWeek.MONDAY), selected = true)

            WeekSelectedDays(
                days = mutableListOf(day)
            ).run {
                updateSelectedState(day)

                selectedDays.first() shouldBe WeekDay(
                    day = Day(day = DayOfWeek.MONDAY),
                    false
                )
            }
        }
    }
})
