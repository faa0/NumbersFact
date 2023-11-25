package com.fara.numbersfact

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.fara.feature_home.navigation.global.featureHomeScreenModule
import com.fara.numbersfact.di.component.main.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

internal class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
        initGlobalNavigation()
    }

    private fun initAppComponent() {
        startKoin {
            module {
                androidContext(this@App)
                androidLogger(level = Level.ERROR)
                modules(appComponent)
            }
        }
    }

    private fun initGlobalNavigation() {
        ScreenRegistry {
            featureHomeScreenModule()
        }
    }
}