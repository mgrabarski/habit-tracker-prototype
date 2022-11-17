package com.mateuszgrabarski.habittracker.business.di

import com.mateuszgrabarski.habittracker.business.data.models.habits.add.NewHabitFactory
import com.mateuszgrabarski.habittracker.business.data.models.user.UserFactory
import com.mateuszgrabarski.habittracker.business.services.cache.HabitCacheDataSource
import com.mateuszgrabarski.habittracker.business.services.cache.UserCacheDataSource
import com.mateuszgrabarski.habittracker.business.services.cache.impl.HabitCacheDataSourceImpl
import com.mateuszgrabarski.habittracker.business.services.cache.impl.UserCacheDataSourceImpl
import com.mateuszgrabarski.habittracker.business.usecases.habit.add.StoreHabit
import com.mateuszgrabarski.habittracker.business.usecases.habit.add.impl.StoreHabitImpl
import com.mateuszgrabarski.habittracker.business.usecases.user.CreateUserIfNeeded
import com.mateuszgrabarski.habittracker.business.usecases.user.impl.CreateUserIfNeededImpl
import org.koin.dsl.module

private val modelsModule = module {
    factory { NewHabitFactory() }
    factory { UserFactory() }
}

private val servicesModule = module {
    factory<HabitCacheDataSource> { HabitCacheDataSourceImpl(get()) }
    factory<UserCacheDataSource> { UserCacheDataSourceImpl(get()) }
}

private val useCasesModule = module {
    factory<CreateUserIfNeeded> { CreateUserIfNeededImpl(get(), get(), get()) }
    factory<StoreHabit> { StoreHabitImpl(get(), get()) }
}

val businessModules = listOf(
    modelsModule,
    servicesModule,
    useCasesModule
)
