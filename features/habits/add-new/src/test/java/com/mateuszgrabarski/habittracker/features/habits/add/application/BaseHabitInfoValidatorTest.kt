package com.mateuszgrabarski.habittracker.features.habits.add.application

import com.mateuszgrabarski.habittracker.business.habits.HabitType
import com.mateuszgrabarski.habittracker.features.habits.add.ui.dialog.HabitIcon
import com.mateuszgrabarski.habittracker.features.habits.add.ui.model.SelectedIcon
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class BaseHabitInfoValidatorTest : DescribeSpec({

    val sut = BaseHabitInfoValidator()

    describe("validation") {

        it("given selected icon, valid habit name and type then should be valid") {
            sut.isValid(
                selectedIcon = VALID_ICON,
                habitName = VALID_NAME,
                habitType = VALID_TYPE
            ).shouldBeTrue()
        }

        it("given not valid icon but valid name and type then should be not valid") {
            sut.isValid(
                selectedIcon = null,
                habitName = VALID_NAME,
                habitType = VALID_TYPE
            ).shouldBeFalse()
        }

        it("given valid icon and type but empty name then should be not valid") {
            sut.isValid(
                selectedIcon = VALID_ICON,
                habitName = EMPTY_VALID_NAME,
                habitType = VALID_TYPE
            ).shouldBeFalse()
        }

        it("given valid icon and type but not valid name then should be not valid") {
            sut.isValid(
                selectedIcon = VALID_ICON,
                habitName = NOT_VALID_NAME,
                habitType = VALID_TYPE
            ).shouldBeFalse()
        }

        it("given valid icon and type but valid name (min number of characters) then should be valid") {
            sut.isValid(
                selectedIcon = VALID_ICON,
                habitName = MIN_VALID_NAME,
                habitType = VALID_TYPE
            ).shouldBeFalse()
        }

        describe("type") {

            it("given not selected type then should be not valid") {
                sut.isValid(
                    selectedIcon = VALID_ICON,
                    habitName = VALID_NAME,
                    habitType = HabitType.getNotSelectableType()
                ).shouldBeFalse()
            }

            describe("given selected type should be valid") {

                HabitType.getSelectableTypes().forEach {
                    it("$it") {
                        sut.isValid(
                            selectedIcon = VALID_ICON,
                            habitName = VALID_NAME,
                            habitType = it
                        ).shouldBeTrue()
                    }
                }
            }
        }
    }
})

private val VALID_ICON = SelectedIcon(
    icon = HabitIcon.Water,
    color = "some color"
)

private const val VALID_NAME = "some name"
private const val EMPTY_VALID_NAME = ""
private const val NOT_VALID_NAME = "ab"
private const val MIN_VALID_NAME = "abc"

private val VALID_TYPE = HabitType.YesOrNo
