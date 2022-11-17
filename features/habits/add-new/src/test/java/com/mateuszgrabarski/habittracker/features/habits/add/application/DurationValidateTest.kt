package com.mateuszgrabarski.habittracker.features.habits.add.application

import com.mateuszgrabarski.habittracker.business.habits.HabitDuration
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.month.MonthDay
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.week.WeekDay
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class DurationValidateTest : DescribeSpec({

    val sut = DurationValidator()

    describe("validate") {

        describe("duration type is every day") {

            it("week days and month days are empty then valid") {
                sut.validate(
                    type = HabitDuration.EveryDay,
                    weekDays = emptyList(),
                    monthDays = emptyList()
                ).shouldBeTrue()
            }

            it("week days and month dats are not selected then valid") {
                sut.validate(
                    type = HabitDuration.EveryDay,
                    weekDays = WeekDay.generateNotSelectedWeekDays(),
                    monthDays = MonthDay.generateNotSelectedDays()
                ).shouldBeTrue()
            }
        }

        describe("duration type is days in week") {

            it("all are selected then should be valid") {
                sut.validate(
                    type = HabitDuration.DaysInWeek,
                    weekDays = WeekDay.generateNotSelectedWeekDays().map {
                        it.reverse()
                    },
                    monthDays = emptyList()
                ).shouldBeTrue()
            }

            it("at least one day must be selected") {
                sut.validate(
                    type = HabitDuration.DaysInWeek,
                    weekDays = WeekDay.generateNotSelectedWeekDays().toMutableList()
                        .apply {
                            this[0] = this[0].reverse()
                        },
                    monthDays = emptyList()
                ).shouldBeTrue()
            }

            it("given all not selected then should be not valid") {
                sut.validate(
                    type = HabitDuration.DaysInWeek,
                    weekDays = WeekDay.generateNotSelectedWeekDays(),
                    monthDays = emptyList()
                ).shouldBeFalse()
            }
        }

        describe("duration type is days in month") {

            it("given not empty week days should be not valid") {
                sut.validate(
                    type = HabitDuration.DaysInMonth,
                    weekDays = WeekDay.generateNotSelectedWeekDays(),
                    monthDays = emptyList()
                ).shouldBeFalse()
            }

            it("given all not selected then should not be valid") {
                sut.validate(
                    type = HabitDuration.DaysInMonth,
                    weekDays = emptyList(),
                    monthDays = MonthDay.generateNotSelectedDays()
                ).shouldBeFalse()
            }

            it("given empty week days should be valid") {
                sut.validate(
                    type = HabitDuration.DaysInMonth,
                    weekDays = emptyList(),
                    monthDays = MonthDay.generateNotSelectedDays().map {
                        it.reverse()
                    }
                ).shouldBeTrue()
            }

            it("at least one of days must be selected") {
                sut.validate(
                    type = HabitDuration.DaysInMonth,
                    weekDays = emptyList(),
                    monthDays = MonthDay.generateNotSelectedDays().toMutableList().apply {
                        this[5] = this[5].reverse()
                    }
                ).shouldBeTrue()
            }
        }
    }
})
