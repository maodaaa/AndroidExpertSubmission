package com.compose.androidexpertc1.presentation.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val themeDarkColorScheme = darkColorScheme(
    primary = themeDarkPrimary,
    onPrimary = themeDarkOnPrimary,
    primaryContainer = themeDarkPrimaryContainer,
    onPrimaryContainer = themeDarkOnPrimaryContainer,
    inversePrimary = themeDarkPrimaryInverse,
    secondary = themeDarkSecondary,
    onSecondary = themeDarkOnSecondary,
    secondaryContainer = themeDarkSecondaryContainer,
    onSecondaryContainer = themeDarkOnSecondaryContainer,
    tertiary = themeDarkTertiary,
    onTertiary = themeDarkOnTertiary,
    tertiaryContainer = themeDarkTertiaryContainer,
    onTertiaryContainer = themeDarkOnTertiaryContainer,
    error = themeDarkError,
    onError = themeDarkOnError,
    errorContainer = themeDarkErrorContainer,
    onErrorContainer = themeDarkOnErrorContainer,
    background = themeDarkBackground,
    onBackground = themeDarkOnBackground,
    surface = themeDarkSurface,
    onSurface = themeDarkOnSurface,
    inverseSurface = themeDarkInverseSurface,
    inverseOnSurface = themeDarkInverseOnSurface,
    surfaceVariant = themeDarkSurfaceVariant,
    onSurfaceVariant = themeDarkOnSurfaceVariant,
    outline = themeDarkOutline,
)

private val themeLightColorScheme = lightColorScheme(
    primary = themeLightPrimary,
    onPrimary = themeLightOnPrimary,
    primaryContainer = themeLightPrimaryContainer,
    onPrimaryContainer = themeLightOnPrimaryContainer,
    inversePrimary = themeLightPrimaryInverse,
    secondary = themeLightSecondary,
    onSecondary = themeLightOnSecondary,
    secondaryContainer = themeLightSecondaryContainer,
    onSecondaryContainer = themeLightOnSecondaryContainer,
    tertiary = themeLightTertiary,
    onTertiary = themeLightOnTertiary,
    tertiaryContainer = themeLightTertiaryContainer,
    onTertiaryContainer = themeLightOnTertiaryContainer,
    error = themeLightError,
    onError = themeLightOnError,
    errorContainer = themeLightErrorContainer,
    onErrorContainer = themeLightOnErrorContainer,
    background = themeLightBackground,
    onBackground = themeLightOnBackground,
    surface = themeLightSurface,
    onSurface = themeLightOnSurface,
    inverseSurface = themeLightInverseSurface,
    inverseOnSurface = themeLightInverseOnSurface,
    surfaceVariant = themeLightSurfaceVariant,
    onSurfaceVariant = themeLightOnSurfaceVariant,
    outline = themeLightOutline,
)

@Composable
fun AndroidExpertC1Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val themeColorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> themeDarkColorScheme
        else -> themeLightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = themeColorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = themeColorScheme,
        typography = themeTypography,
        shapes = shapes,
        content = content,
    )
}