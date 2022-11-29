package com.mateuszgrabarski.habittracker.business.data.models.habits.add

import com.mateuszgrabarski.habittracker.business.data.models.habits.HabitTypeData
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class InputDescriptionTest : DescribeSpec({

    describe("number") {

        it("map habit data") {
            InputDescription.Number(
                goal = 1.0,
                unit = "kg"
            ).toHabitTypeData() shouldBe HabitTypeData.NumberData(
                goal = 1.0,
                unit = "kg"
            )
        }
    }

    describe("time") {

        it("map habit data") {
            InputDescription.Time(
                hours = 1,
                minutes = 1
            ).toHabitTypeData() shouldBe HabitTypeData.TimeData(
                hours = 1,
                minutes = 1
            )
        }
    }
})
