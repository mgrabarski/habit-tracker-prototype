package com.mateuszgrabarski.habittracker.framework.database.di

import com.mateuszgrabarski.habittracker.business.services.cache.abstraction.HabitDaoService
import com.mateuszgrabarski.habittracker.business.services.cache.abstraction.UserDaoService
import com.mateuszgrabarski.habittracker.framework.database.DatabaseDescription.DatabaseDiScope
import com.mateuszgrabarski.habittracker.framework.database.HabitDatabase
import com.mateuszgrabarski.habittracker.framework.database.application.LocalTimeProvider
import com.mateuszgrabarski.habittracker.framework.database.application.impl.LocalTimeProviderImpl
import com.mateuszgrabarski.habittracker.framework.database.services.LocalHabitDaoService
import com.mateuszgrabarski.habittracker.framework.database.services.LocalUserDaoService
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.time.ZoneOffset

val localDatabaseModule = module {
    single(named(DatabaseDiScope)) { HabitDatabase.buildDatabase(androidContext()) }
    factory { (get(named(DatabaseDiScope)) as HabitDatabase).provideUserDao() }
    factory { (get(named(DatabaseDiScope)) as HabitDatabase).provideHabitDao() }
    factory { (get(named(DatabaseDiScope)) as HabitDatabase).provideHabitTypeDetailsDao() }
    factory { (get(named(DatabaseDiScope)) as HabitDatabase).provideHabitDurationDao() }
    factory { (get(named(DatabaseDiScope)) as HabitDatabase).provideHabitAndDetailsRelationDao() }
    factory<UserDaoService> { LocalUserDaoService(get(), get()) }
    factory<HabitDaoService> { LocalHabitDaoService(get(), get()) }
    factory<LocalTimeProvider> { LocalTimeProviderImpl(ZoneOffset.UTC) }
}
