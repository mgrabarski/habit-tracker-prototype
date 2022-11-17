package com.mateuszgrabarski.habittracker.framework.storage.di

import com.mateuszgrabarski.habittracker.business.services.storage.UserStorage
import com.mateuszgrabarski.habittracker.framework.storage.local.LocalUserStorage
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val storageModule = module {
    factory<UserStorage> { LocalUserStorage(androidContext()) }
}
