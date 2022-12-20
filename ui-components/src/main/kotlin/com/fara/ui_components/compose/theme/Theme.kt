package com.fara.ui_components.compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.fara.ui_components.DefaultColor

private val LightColorPalette = lightColors(
    primary = DefaultColor.Light().primary,
    primaryVariant = DefaultColor.Light().primaryVariant,
    secondary = DefaultColor.Light().secondary,
    secondaryVariant = DefaultColor.Light().secondaryVariant,
    background = DefaultColor.Light().background,
    surface = DefaultColor.Light().surface,
    error = DefaultColor.Light().error,
    onPrimary = DefaultColor.Light().onPrimary,
    onSecondary = DefaultColor.Light().onSecondary,
    onBackground = DefaultColor.Light().onBackground,
    onSurface = DefaultColor.Light().onSurface,
    onError = DefaultColor.Light().onError
)

private val DarkColorPalette = darkColors(
    primary = DefaultColor.Dark().primary,
    primaryVariant = DefaultColor.Dark().primaryVariant,
    secondary = DefaultColor.Dark().secondary,
    secondaryVariant = DefaultColor.Dark().secondaryVariant,
    background = DefaultColor.Dark().background,
    surface = DefaultColor.Dark().surface,
    error = DefaultColor.Dark().error,
    onPrimary = DefaultColor.Dark().onPrimary,
    onSecondary = DefaultColor.Dark().onSecondary,
    onBackground = DefaultColor.Dark().onBackground,
    onSurface = DefaultColor.Dark().onSurface,
    onError = DefaultColor.Dark().onError
)

@OptIn(ExperimentalUnitApi::class)
@Composable
fun DefaultTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    CompositionLocalProvider(/*LocalCustomTypography provides customTypography*/) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            content = content
        )
    }
}

//@OptIn(ExperimentalUnitApi::class)
//object CustomTheme {
//    val typography: CustomTypography
//        @Composable
//        get() = LocalCustomTypography.current
//
//    val colors: CustomColor
//        @Composable
//        get() = if (isSystemInDarkTheme())
//            LocalCustomDarkColor.current
//        else
//            LocalCustomLightColor.current
//}
