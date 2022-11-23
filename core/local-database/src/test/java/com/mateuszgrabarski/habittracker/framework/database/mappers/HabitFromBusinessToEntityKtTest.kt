package com.mateuszgrabarski.habittracker.framework.database.mappers

import com.mateuszgrabarski.habittracker.business.data.models.habits.HabitTypeData
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitType
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitIconEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.NumberDataEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.TimeDataEntity
import com.mateuszgrabarski.habittracker.framework.database.fixtures.NewHabitFixtures.anyNewHabit
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class HabitFromBusinessToEntityKtTest : DescribeSpec({

    describe("map from business to entities relations") {

        describe("base habit data") {

            it("is filled") {
                val habit = anyNewHabit()

                val result = habit.fromBusinessToEntitiesRelations()

                result.habit.id shouldBe habit.id
                result.habit.name shouldBe habit.name
                result.habit.description shouldBe habit.description
                result.habit.icon shouldBe HabitIconEntity(
                    image = habit.icon.icon,
                    color = habit.icon.color
                )
                result.habit.userId shouldBe habit.ownerId
            }
        }

        describe("type details") {

            it("given not needed inputs then should be data nulls") {
                val habit = anyNewHabit(
                    type = HabitType.YesOrNo,
                    inputs = HabitTypeData.NotNeededData
                )

                val result = habit.fromBusinessToEntitiesRelations()

                result.typeDetails.type shouldBe HabitType.YesOrNo
                result.typeDetails.numberData.shouldBeNull()
                result.typeDetails.timeData.shouldBeNull()
            }

            it("given number data should be mapped to entity") {
                val habit = anyNewHabit(
                    type = HabitType.Number,
                    inputs = HabitTypeData.NumberData(
                        goal = 1.0,
                        unit = "kg"
                    )
                )

                val result = habit.fromBusinessToEntitiesRelations()

                result.typeDetails.type shouldBe HabitType.Number
                result.typeDetails.numberData shouldBe NumberDataEntity(
                    goal = 1.0,
                    unit = "kg"
                )
                result.typeDetails.timeData.shouldBeNull()
            }

            it("given time data should be mapped to entity") {
                val habit = anyNewHabit(
                    type = HabitType.Timer,
                    inputs = HabitTypeData.TimeData(
                        hours = 1,
                        minutes = 1
                    )
                )

                val result = habit.fromBusinessToEntitiesRelations()

                result.typeDetails.type shouldBe HabitType.Timer
                result.typeDetails.numberData.shouldBeNull()
                result.typeDetails.timeData shouldBe TimeDataEntity(
                    hours = 1,
                    minutes = 1
                )
            }
        }

        describe("duration") {

            it("should be mapped") {
                val habit = anyNewHabit()

                val result = habit.fromBusinessToEntitiesRelations()

                result.duration.startDate shouldBe habit.startDate
                result.duration.endDate shouldBe habit.endDate
                result.duration.duration shouldBe habit.duration
                result.duration.weekDays shouldBe habit.weekDays
                result.duration.monthDays shouldBe habit.monthDays
                result.duration.habitId shouldBe habit.id
            }
        }
    }
})
