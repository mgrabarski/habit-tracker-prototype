package com.mateuszgrabarski.habittracker.features.habits.add.application

import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitIcon
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitType
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.NumberInputs
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.SelectedIcon
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.SelectedTime
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.TimeInputs
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
                habitType = VALID_TYPE,
                inputs = null
            ).shouldBeTrue()
        }

        it("given not valid icon but valid name and type then should be not valid") {
            sut.isValid(
                selectedIcon = null,
                habitName = VALID_NAME,
                habitType = VALID_TYPE,
                inputs = null
            ).shouldBeFalse()
        }

        it("given valid icon and type but empty name then should be not valid") {
            sut.isValid(
                selectedIcon = VALID_ICON,
                habitName = EMPTY_VALID_NAME,
                habitType = VALID_TYPE,
                inputs = null
            ).shouldBeFalse()
        }

        it("given valid icon and type but not valid name then should be not valid") {
            sut.isValid(
                selectedIcon = VALID_ICON,
                habitName = NOT_VALID_NAME,
                habitType = VALID_TYPE,
                inputs = null
            ).shouldBeFalse()
        }

        it("given valid icon and type but valid name (min number of characters) then should be valid") {
            sut.isValid(
                selectedIcon = VALID_ICON,
                habitName = MIN_VALID_NAME,
                habitType = VALID_TYPE,
                inputs = null
            ).shouldBeFalse()
        }

        describe("type") {

            it("given not selected type then should be not valid") {
                sut.isValid(
                    selectedIcon = VALID_ICON,
                    habitName = VALID_NAME,
                    habitType = HabitType.getNotSelectableType(),
                    inputs = null
                ).shouldBeFalse()
            }
        }
    }

    describe("validate inputs") {

        describe("given valid icon, name and type") {

            describe("none") {

                it("given some inputs should be not valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.None,
                        inputs = NumberInputs(
                            goal = 0.0,
                            unit = ""
                        )
                    ).shouldBeFalse()
                }

                it("given null inputs should be not valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.None,
                        inputs = null
                    ).shouldBeFalse()
                }
            }

            describe("yes or no") {

                it("given some inputs should be not valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.YesOrNo,
                        inputs = NumberInputs(
                            goal = 0.0,
                            unit = ""
                        )
                    ).shouldBeFalse()
                }

                it("given null inputs should be valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.YesOrNo,
                        inputs = null
                    ).shouldBeTrue()
                }
            }

            describe("number") {

                it("given null inputs should be not valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.Number,
                        inputs = null
                    ).shouldBeFalse()
                }

                it("given zero goal should be not valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.Number,
                        inputs = NumberInputs(
                            goal = 0.0,
                            unit = "kg"
                        )
                    ).shouldBeFalse()
                }

                it("given empty unit should be not valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.Number,
                        inputs = NumberInputs(
                            goal = 1.0,
                            unit = ""
                        )
                    ).shouldBeFalse()
                }

                it("given valid goal and unit should be valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.Number,
                        inputs = NumberInputs(
                            goal = 1.0,
                            unit = "kg"
                        )
                    ).shouldBeTrue()
                }
            }

            describe("timer") {

                it("given null inputs should be not valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.Timer,
                        inputs = null
                    ).shouldBeFalse()
                }

                it("given time with zero hours and minutes should not be valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.Timer,
                        inputs = TimeInputs(
                            time = SelectedTime(
                                hours = 0,
                                minutes = 0
                            )
                        )
                    ).shouldBeFalse()
                }

                it("given negative hours should not be valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.Timer,
                        inputs = TimeInputs(
                            time = SelectedTime(
                                hours = -10,
                                minutes = 10
                            )
                        )
                    ).shouldBeFalse()
                }

                it("given negative minutes should not be valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.Timer,
                        inputs = TimeInputs(
                            time = SelectedTime(
                                hours = 10,
                                minutes = -10
                            )
                        )
                    ).shouldBeFalse()
                }

                it("given zero hours but positive number of minutes should be valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.Timer,
                        inputs = TimeInputs(
                            time = SelectedTime(
                                hours = 0,
                                minutes = 10
                            )
                        )
                    ).shouldBeTrue()
                }

                it("given positive number of hours but zero minutes should be valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.Timer,
                        inputs = TimeInputs(
                            time = SelectedTime(
                                hours = 10,
                                minutes = 0
                            )
                        )
                    ).shouldBeTrue()
                }

                it("given positive number of hours and minutes should be valid") {
                    sut.isValid(
                        selectedIcon = VALID_ICON,
                        habitName = VALID_NAME,
                        habitType = HabitType.Timer,
                        inputs = TimeInputs(
                            time = SelectedTime(
                                hours = 10,
                                minutes = 10
                            )
                        )
                    ).shouldBeTrue()
                }
            }
        }
    }
})

private val VALID_ICON = SelectedIcon(
    icon = HabitIcon.Water,
    color = 0
)

private const val VALID_NAME = "some name"
private const val EMPTY_VALID_NAME = ""
private const val NOT_VALID_NAME = "ab"
private const val MIN_VALID_NAME = "abc"

private val VALID_TYPE = HabitType.YesOrNo
