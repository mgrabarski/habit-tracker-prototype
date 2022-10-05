package com.mateuszgrabarski.habittracker.resources.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val green = Color(0xFF355C03)

val Colors.splashScreenBackground: Color
    @Composable
    get() = if (isLight) green else green
