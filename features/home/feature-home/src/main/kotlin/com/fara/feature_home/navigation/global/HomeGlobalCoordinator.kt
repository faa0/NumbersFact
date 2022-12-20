package com.fara.feature_home.navigation.global

import cafe.adriel.voyager.core.registry.screenModule
import com.fara.feature_home.presentation.ui.screen.detail.DetailScreen
import com.fara.feature_home.presentation.ui.screen.home.HomeScreen
import com.fara.navigation.screen.SharedScreen

val featureHomeScreenModule = screenModule {
    register<SharedScreen.HomeScreen> {
        HomeScreen()
    }
    register<SharedScreen.DetailScreen> { provider ->
        DetailScreen(provider.numberId)
    }
}