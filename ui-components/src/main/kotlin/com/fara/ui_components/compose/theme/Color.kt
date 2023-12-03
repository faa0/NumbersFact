package com.fara.ui_components.compose.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalCustomLightColor = staticCompositionLocalOf { CustomColor.Light() }
val LocalCustomDarkColor = staticCompositionLocalOf { CustomColor.Dark() }

sealed class DefaultColor {

    abstract val primary: Color
    abstract val primaryVariant: Color
    abstract val secondary: Color
    abstract val secondaryVariant: Color
    abstract val background: Color
    abstract val surface: Color
    abstract val error: Color
    abstract val onPrimary: Color
    abstract val onSecondary: Color
    abstract val onBackground: Color
    abstract val onSurface: Color
    abstract val onError: Color

    class Light : DefaultColor() {
        override val primary = Color(0xFF4372F5)
        override val primaryVariant: Color = Color(0x4372F566)
        override val secondary: Color = Color(0xFFF62C3E)
        override val secondaryVariant: Color = Color(0xFFF62C3E)
        override val background: Color = Color(0xFF151515)
        override val surface: Color = Color(0xFF939393)
        override val error: Color = Color(0xFFF95733)
        override val onPrimary: Color = Color(0x4372F566)
        override val onSecondary: Color = Color(0xFFFFFF66)
        override val onBackground: Color = Color(0xFF212121)
        override val onSurface: Color = Color(0x292929A6)
        override val onError: Color = Color(0xFFF95733)
    }

    open class Dark : DefaultColor() {
        override val primary: Color = Color(0xFF4372F5)
        override val primaryVariant: Color = Color(0x4372F566)
        override val secondary: Color = Color(0xFFF62C3E)
        override val secondaryVariant: Color = Color(0xFFF62C3E)
        override val background: Color = Color(0xFF171C19)
        override val surface: Color = Color(0xFF939393)
        override val error: Color = Color(0xFFF95733)
        override val onPrimary: Color = Color(0x4372F566)
        override val onSecondary: Color = Color(0xFFFFFF66)
        override val onBackground: Color = Color(0xFF212121)
        override val onSurface: Color = Color(0x292929A6)
        override val onError: Color = Color(0xFFF95733)
    }
}

sealed class CustomColor {
    open class Light : CustomColor()
    open class Dark : Light()
}