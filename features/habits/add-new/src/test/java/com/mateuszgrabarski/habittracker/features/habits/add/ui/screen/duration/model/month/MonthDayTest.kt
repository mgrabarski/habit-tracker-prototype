package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.month

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class MonthDayTest : DescribeSpec({

    describe("reverse") {

        it("given selected should returns not selected") {
            MonthDay(dayNumber = 1, selected = true).reverse() shouldBe
                MonthDay(dayNumber = 1, selected = false)
        }

        it("given selected should returns selected") {
            MonthDay(dayNumber = 1, selected = false).reverse() shouldBe
                MonthDay(dayNumber = 1, selected = true)
        }
    }

    describe("generate") {

        it("list of all not selected days") {
            MonthDay.generateNotSelectedDays().run {
                size shouldBe MonthDay.MAX_NUMBER_OF_DAYS

                this.forEachIndexed { index, monthDay ->
                    monthDay shouldBe MonthDay(dayNumber = index + 1, selected = false)
                }
            }
        }
    }
})
