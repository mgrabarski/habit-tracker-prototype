package com.mateuszgrabarski.habittracker.business.habits

import com.mateuszgrabarski.habittracker.resources.R
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe

class HabitTypeTest : DescribeSpec({

    describe("companion object") {

        describe("get not selectable type") {

            it("should be None type") {
                HabitType.getNotSelectableType() shouldBe HabitType.None
            }
        }

        describe("get selectable types") {
            HabitType.getSelectableTypes().run {
                size shouldBe 3
                shouldContainInOrder(
                    HabitType.YesOrNo,
                    HabitType.Number,
                    HabitType.Timer
                )
            }
        }

        describe("from id to item") {

            it("None") {
                HabitType.fromIdToSelectedItem(stringId = R.string.habit_type_none) shouldBe HabitType.None
            }

            it("YesOrNo") {
                HabitType.fromIdToSelectedItem(stringId = R.string.habit_type_yes_or_no) shouldBe HabitType.YesOrNo
            }

            it("Number") {
                HabitType.fromIdToSelectedItem(stringId = R.string.habit_type_number) shouldBe HabitType.Number
            }

            it("Timer") {
                HabitType.fromIdToSelectedItem(stringId = R.string.habit_type_timer) shouldBe HabitType.Timer
            }
        }
    }
})
