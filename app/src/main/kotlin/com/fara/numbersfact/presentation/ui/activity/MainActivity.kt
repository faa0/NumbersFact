package com.fara.numbersfact.presentation.ui.activity

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.fara.navigation.screen.SharedScreen
import com.fara.numbersfact.R
import com.fara.ui_components.compose.theme.DefaultTheme

internal class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DefaultTheme {
                Scaffold(
                    content = {
                        val homeScreen = rememberScreen(provider = SharedScreen.HomeScreen)
                        Navigator(screen = homeScreen)
                    }
                )
            }
        }
    }

    override fun getTheme(): Resources.Theme {
        val theme = super.getTheme()
        theme.applyStyle(R.style.Theme_NumbersFact, true)
        return theme
    }
}