package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate

class SelectedDateTest : DescribeSpec({

    val today = SelectedDate.from(date = LocalDate.of(2022, 11, 17))

    describe("month value") {

        it("minus one for android framework") {
            today.monthValue shouldBe today.month - 1
        }
    }

    describe("display value") {

        it("format date") {
            today.displayValue shouldBe "17-11-2022"
        }
    }
})
