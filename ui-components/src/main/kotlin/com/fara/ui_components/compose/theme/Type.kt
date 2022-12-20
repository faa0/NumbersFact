package com.fara.ui_components.compose.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp

@ExperimentalUnitApi
val Typography = Typography()

@ExperimentalUnitApi
val LocalCustomTypography = staticCompositionLocalOf { /*customTypography*/ }

//@ExperimentalUnitApi
//val customTypography = CustomTypography()
//
//@Immutable
//data class CustomTypography()