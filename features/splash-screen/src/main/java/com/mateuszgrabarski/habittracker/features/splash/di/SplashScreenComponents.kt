package com.mateuszgrabarski.habittracker.features.splash.di

import com.mateuszgrabarski.habittracker.features.splash.screen.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashScreenModule = module {
    viewModel { SplashScreenViewModel(get()) }
}
