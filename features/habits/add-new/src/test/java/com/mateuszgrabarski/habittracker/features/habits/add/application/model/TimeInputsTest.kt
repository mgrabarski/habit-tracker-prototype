package com.mateuszgrabarski.habittracker.features.habits.add.application.model

import com.mateuszgrabarski.habittracker.business.habits.add.InputDescription
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TimeInputsTest : DescribeSpec({

    describe("to input description") {

        it("maps") {
            TimeInputs(
                time = SelectedTime(
                    hours = 1,
                    minutes = 1
                )
            ).toInputDescription() shouldBe InputDescription.Time(
                hours = 1,
                minutes = 1
            )
        }
    }
})
