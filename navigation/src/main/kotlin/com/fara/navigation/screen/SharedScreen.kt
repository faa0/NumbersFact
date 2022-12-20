package com.fara.navigation.screen

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    object HomeScreen : SharedScreen()
    data class DetailScreen(val numberId: Int) : SharedScreen()
}