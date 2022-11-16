package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.time.DayOfWeek
import java.util.Locale

class DayTest : DescribeSpec({

    describe("us") {

        beforeEach {
            Locale.setDefault(Locale.US)
        }

        describe("short name") {

            it("should be short") {
                Day(day = DayOfWeek.MONDAY).name shouldBe "Mon"
                Day(day = DayOfWeek.TUESDAY).name shouldBe "Tue"
                Day(day = DayOfWeek.WEDNESDAY).name shouldBe "Wed"
                Day(day = DayOfWeek.THURSDAY).name shouldBe "Thu"
                Day(day = DayOfWeek.FRIDAY).name shouldBe "Fri"
                Day(day = DayOfWeek.SATURDAY).name shouldBe "Sat"
                Day(day = DayOfWeek.SUNDAY).name shouldBe "Sun"
            }
        }
    }

    describe("uk") {

        beforeEach {
            Locale.setDefault(Locale.UK)
        }

        describe("short name") {

            it("should be short") {
                Day(day = DayOfWeek.MONDAY).name shouldBe "Mon"
                Day(day = DayOfWeek.TUESDAY).name shouldBe "Tue"
                Day(day = DayOfWeek.WEDNESDAY).name shouldBe "Wed"
                Day(day = DayOfWeek.THURSDAY).name shouldBe "Thu"
                Day(day = DayOfWeek.FRIDAY).name shouldBe "Fri"
                Day(day = DayOfWeek.SATURDAY).name shouldBe "Sat"
                Day(day = DayOfWeek.SUNDAY).name shouldBe "Sun"
            }
        }
    }

    describe("pl") {

        beforeEach {
            Locale.setDefault(Locale("pl", "PL"))
        }

        describe("short name") {

            it("should be short") {
                Day(day = DayOfWeek.MONDAY).name shouldBe "pon."
                Day(day = DayOfWeek.TUESDAY).name shouldBe "wt."
                Day(day = DayOfWeek.WEDNESDAY).name shouldBe "śr."
                Day(day = DayOfWeek.THURSDAY).name shouldBe "czw."
                Day(day = DayOfWeek.FRIDAY).name shouldBe "pt."
                Day(day = DayOfWeek.SATURDAY).name shouldBe "sob."
                Day(day = DayOfWeek.SUNDAY).name shouldBe "niedz."
            }
        }
    }
})
