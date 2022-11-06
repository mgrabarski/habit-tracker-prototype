package com.mateuszgrabarski.habittracker.resources.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple50 = Color(0xFFede7f6)
val Purple100 = Color(0xFFd1c4e9)
val Purple200 = Color(0xFFb39ddb)
val Purple300 = Color(0xFF9575cd)
val Purple400 = Color(0xFF7e57c2)
val Purple500 = Color(0xFF673ab7)
val Purple600 = Color(0xFF5e35b1)
val Purple700 = Color(0xFF512da8)
val Purple800 = Color(0xFF4527a0)
val Purple900 = Color(0xFF311b92)
val PurpleA100 = Color(0xFFb388ff)
val PurpleA200 = Color(0xFF7c4dff)
val PurpleA400 = Color(0xFF651fff)
val PurpleA700 = Color(0xFF6200ea)

val Orange50 = Color(0xFFfff3e0)
val Orange100 = Color(0xFFffe0b2)
val Orange200 = Color(0xFFffcc80)
val Orange300 = Color(0xFFffb74d)
val Orange400 = Color(0xFFffa726)
val Orange500 = Color(0xFFff9800)
val Orange600 = Color(0xFFfb8c00)
val Orange700 = Color(0xFFf57c00)
val Orange800 = Color(0xFFef6c00)
val Orange900 = Color(0xFFe65100)
val OrangeA100 = Color(0xFFffd180)
val OrangeA200 = Color(0xFFffab40)
val OrangeA400 = Color(0xFFff9100)
val OrangeA700 = Color(0xFFff6d00)

val Grey50 = Color(0xFFfafafa)
val Grey100 = Color(0xFFf5f5f5)
val Grey200 = Color(0xFFeeeeee)
val Grey300 = Color(0xFFe0e0e0)
val Grey400 = Color(0xFFbdbdbd)
val Grey500 = Color(0xFF9e9e9e)
val Grey600 = Color(0xFF757575)
val Grey700 = Color(0xFF616161)
val Grey800 = Color(0xFF424242)
val Grey900 = Color(0xFF212121)

val primaryColor = Purple700
val primaryLightColor = Purple300
val secondaryColor = Orange700
val secondaryLightColor = Orange300
val primaryTextColor = Color(0xFFffffff)
val secondaryTextColor = Color(0xFFfafafa)

val Colors.splashScreenBackground: Color
    @Composable
    get() = Purple700

val Colors.bottomBarBackground: Color
    @Composable
    get() = Purple600

val Colors.bottomBarContent: Color
    @Composable
    get() = primaryTextColor

val Colors.topBarBackground: Color
    @Composable
    get() = Purple600

val Colors.topBarContent: Color
    @Composable
    get() = primaryTextColor

val Colors.TopAppBarActionButton: Color
    @Composable
    get() = Grey50

val Colors.BorderColor: Color
    @Composable
    get() = Purple600
