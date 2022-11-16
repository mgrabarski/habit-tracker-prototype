package com.mateuszgrabarski.habittracker.resources.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFF6847C0)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFE8DDFF)
val md_theme_light_onPrimaryContainer = Color(0xFF21005D)
val md_theme_light_secondary = Color(0xFF875200)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFFFDDBA)
val md_theme_light_onSecondaryContainer = Color(0xFF2B1700)
val md_theme_light_tertiary = Color(0xFF6F43C0)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFEBDDFF)
val md_theme_light_onTertiaryContainer = Color(0xFF250059)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFFFBFF)
val md_theme_light_onBackground = Color(0xFF1C1B1E)
val md_theme_light_surface = Color(0xFFFFFBFF)
val md_theme_light_onSurface = Color(0xFF1C1B1E)
val md_theme_light_surfaceVariant = Color(0xFFE6E0EC)
val md_theme_light_onSurfaceVariant = Color(0xFF48454E)
val md_theme_light_outline = Color(0xFF79757F)
val md_theme_light_inverseOnSurface = Color(0xFFF4EFF4)
val md_theme_light_inverseSurface = Color(0xFF313033)
val md_theme_light_inversePrimary = Color(0xFFCEBDFF)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF6847C0)
val md_theme_light_outlineVariant = Color(0xFFCAC4CF)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFFCEBDFF)
val md_theme_dark_onPrimary = Color(0xFF390590)
val md_theme_dark_primaryContainer = Color(0xFF502BA7)
val md_theme_dark_onPrimaryContainer = Color(0xFFE8DDFF)
val md_theme_dark_secondary = Color(0xFFFFB865)
val md_theme_dark_onSecondary = Color(0xFF482A00)
val md_theme_dark_secondaryContainer = Color(0xFF663D00)
val md_theme_dark_onSecondaryContainer = Color(0xFFFFDDBA)
val md_theme_dark_tertiary = Color(0xFFD3BBFF)
val md_theme_dark_onTertiary = Color(0xFF3F008D)
val md_theme_dark_tertiaryContainer = Color(0xFF5727A6)
val md_theme_dark_onTertiaryContainer = Color(0xFFEBDDFF)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF1C1B1E)
val md_theme_dark_onBackground = Color(0xFFE6E1E6)
val md_theme_dark_surface = Color(0xFF1C1B1E)
val md_theme_dark_onSurface = Color(0xFFE6E1E6)
val md_theme_dark_surfaceVariant = Color(0xFF48454E)
val md_theme_dark_onSurfaceVariant = Color(0xFFCAC4CF)
val md_theme_dark_outline = Color(0xFF948F99)
val md_theme_dark_inverseOnSurface = Color(0xFF1C1B1E)
val md_theme_dark_inverseSurface = Color(0xFFE6E1E6)
val md_theme_dark_inversePrimary = Color(0xFF6847C0)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFFCEBDFF)
val md_theme_dark_outlineVariant = Color(0xFF48454E)
val md_theme_dark_scrim = Color(0xFF000000)

val seed = Color(0xFF512DA8)
val CustomColor1 = Color(0xFF512DA8)
val light_CustomColor1 = Color(0xFF6847C0)
val light_onCustomColor1 = Color(0xFFFFFFFF)
val light_CustomColor1Container = Color(0xFFE8DDFF)
val light_onCustomColor1Container = Color(0xFF21005D)
val dark_CustomColor1 = Color(0xFFCEBDFF)
val dark_onCustomColor1 = Color(0xFF390590)
val dark_CustomColor1Container = Color(0xFF502BA7)
val dark_onCustomColor1Container = Color(0xFFE8DDFF)

val Colors.splashScreenBackground: Color
    @Composable
    get() = if (isDarkMode) md_theme_dark_primary else md_theme_light_primary

val Colors.bottomBarBackground: Color
    @Composable
    get() = if (isDarkMode) md_theme_dark_primary else md_theme_light_primary

val Colors.bottomBarContent: Color
    @Composable
    get() = if (isDarkMode) md_theme_dark_onPrimary else md_theme_light_onPrimary

val Colors.topBarBackground: Color
    @Composable
    get() = if (isDarkMode) md_theme_dark_primary else md_theme_light_primary

val Colors.topBarContent: Color
    @Composable
    get() = if (isDarkMode) md_theme_dark_onPrimary else md_theme_light_onPrimary

val Colors.TopAppBarActionButton: Color
    @Composable
    get() = if (isDarkMode) md_theme_dark_onPrimary else md_theme_light_onPrimary

val Colors.BorderColor: Color
    @Composable
    get() = if (isDarkMode) md_theme_dark_primary else md_theme_light_primary
