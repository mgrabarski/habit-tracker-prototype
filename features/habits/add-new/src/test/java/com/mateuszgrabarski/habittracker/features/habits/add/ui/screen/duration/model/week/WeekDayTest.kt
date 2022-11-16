package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.week

import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.Day
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.time.DayOfWeek

class WeekDayTest : DescribeSpec({

    describe("reverse") {

        it("given selected should returns not selected") {
            WeekDay(day = Day(day = DayOfWeek.MONDAY), selected = true).reverse() shouldBe
                WeekDay(day = Day(day = DayOfWeek.MONDAY), selected = false)
        }

        it("given not selected should returns selected") {
            WeekDay(day = Day(day = DayOfWeek.MONDAY), selected = false).reverse() shouldBe
                WeekDay(day = Day(day = DayOfWeek.MONDAY), selected = true)
        }
    }

    describe("generate") {

        it("list of not selected week days") {
            WeekDay.generateNotSelectedWeekDays().run {
                size shouldBe 7
                this.first() shouldBe WeekDay(day = Day(day = DayOfWeek.MONDAY), selected = false)
                this.last() shouldBe WeekDay(day = Day(day = DayOfWeek.SUNDAY), selected = false)
            }
        }
    }
})
