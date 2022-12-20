package com.fara.ui_components.compose.view

import androidx.annotation.ColorRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun NumberTextField(
    modifier: Modifier = Modifier,
    value: String,
    @ColorRes textColor: Color = MaterialTheme.colors.onPrimary,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
    onTextChanged: (String) -> Unit
) {
    var label by remember { mutableStateOf(value) } //TODO change to Empty.String

    TextField(
        modifier = Modifier.then(modifier),
        value = label,
        onValueChange = { valueInner ->
            label = valueInner
            onTextChanged(valueInner)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            textColor = textColor,
        ),
        keyboardOptions = keyboardOptions
    )
}