package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.month

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class MonthSelectedDaysTest : DescribeSpec({

    describe("default") {

        it("should contains all days") {
            MonthSelectedDays().selectedDays shouldBe MonthDay.generateNotSelectedDays()
        }
    }

    describe("custom input") {

        it("should be same as in constructor") {
            val day = MonthDay(dayNumber = 1, selected = false)

            MonthSelectedDays(
                days = mutableListOf(day)
            ).selectedDays shouldBe listOf(day)
        }
    }

    describe("update selected state of day") {

        it("update to selected") {
            val day = MonthDay(dayNumber = 1, selected = false)

            MonthSelectedDays(
                days = mutableListOf(day)
            ).run {
                updateSelectedState(day = day)

                selectedDays[0] shouldBe MonthDay(dayNumber = 1, selected = true)
            }
        }

        it("update to not selected") {
            val day = MonthDay(dayNumber = 1, selected = true)

            MonthSelectedDays(
                days = mutableListOf(day)
            ).run {
                updateSelectedState(day = day)

                selectedDays[0] shouldBe MonthDay(dayNumber = 1, selected = false)
            }
        }
    }
})
