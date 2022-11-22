package com.mateuszgrabarski.habittracker.framework.database.converters

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.shouldBe
import java.time.DayOfWeek.MONDAY
import java.time.DayOfWeek.THURSDAY

class DayOfWeekConverterTest : DescribeSpec({

    val sut = DayOfWeekConverter()

    describe("conversion") {

        describe("to list") {

            it("null to empty list") {
                sut.toList(dateString = null).shouldBeEmpty()
            }

            it("empty string to empty list") {
                sut.toList(dateString = "").shouldBeEmpty()
            }

            it("list of days to list") {
                sut.toList(dateString = "MONDAY,THURSDAY") shouldBe listOf(MONDAY, THURSDAY)
            }
        }

        describe("from list") {

            it("to String") {
                sut.fromList(days = listOf(MONDAY, THURSDAY)) shouldBe "MONDAY,THURSDAY"
            }
        }
    }
})
