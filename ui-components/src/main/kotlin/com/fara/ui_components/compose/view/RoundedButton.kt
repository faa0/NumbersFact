package com.fara.ui_components.compose.view

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RoundedButton(
    modifier: Modifier = Modifier,
    @StringRes stringResId: Int,
    @ColorRes buttonColor: Color = MaterialTheme.colors.primary,
    @ColorRes disabledButtonColor: Color = MaterialTheme.colors.primarySurface,
    @ColorRes textColor: Color = MaterialTheme.colors.onBackground,
    textStyle: TextStyle = MaterialTheme.typography.button,
    buttonHeight: Dp = 48.dp,
    buttonShape: Shape = RoundedCornerShape(100.dp),
    isEnabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth()
            .height(buttonHeight),
        enabled = isEnabled,
        shape = buttonShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonColor,
            disabledBackgroundColor = disabledButtonColor,
        ),
        onClick = onClick
    ) {
        Text(
            text = stringResource(id = stringResId),
            color = textColor,
            style = textStyle
        )
    }
}