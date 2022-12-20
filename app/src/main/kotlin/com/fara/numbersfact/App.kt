package com.fara.numbersfact

import android.app.Application
import android.content.Context
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.fara.common_di.component.app.ApplicationComponentDependencies
import com.fara.common_di.component.app.ApplicationComponentHolder
import com.fara.feature_home.navigation.global.featureHomeScreenModule

internal class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
        initGlobalNavigation()
    }

    private fun initAppComponent() {
        ApplicationComponentHolder.init(object : ApplicationComponentDependencies {
            override val context: Context
                get() = this@App
        })
    }

    private fun initGlobalNavigation() {
        ScreenRegistry {
            featureHomeScreenModule()
        }
    }
}