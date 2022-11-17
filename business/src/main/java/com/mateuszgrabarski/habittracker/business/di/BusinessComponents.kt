package com.mateuszgrabarski.habittracker.business.di

import com.mateuszgrabarski.habittracker.business.data.models.habits.add.NewHabitFactory
import com.mateuszgrabarski.habittracker.business.services.cache.HabitCacheDataSource
import com.mateuszgrabarski.habittracker.business.services.cache.impl.HabitCacheDataSourceImpl
import com.mateuszgrabarski.habittracker.business.usecases.habit.add.StoreHabit
import com.mateuszgrabarski.habittracker.business.usecases.habit.add.impl.StoreHabitImpl
import org.koin.dsl.module

private val modelsModule = module {
    factory { NewHabitFactory() }
}

private val servicesModule = module {
    factory<HabitCacheDataSource> { HabitCacheDataSourceImpl(get()) }
}

private val useCasesModule = module {
    factory<StoreHabit> { StoreHabitImpl(get(), get()) }
}

val businessModules = listOf(
    modelsModule,
    servicesModule,
    useCasesModule
)
