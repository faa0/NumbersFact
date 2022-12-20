package com.fara.feature_home.di.component

import com.fara.feature_home.presentation.ui.screen.detail.DetailScreen
import com.fara.feature_home.presentation.ui.screen.home.HomeScreen

internal interface HomeScreenComponent {

    fun inject(screen: HomeScreen)

    fun inject(screen: DetailScreen)
}
