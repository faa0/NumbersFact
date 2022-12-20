package com.fara.numbersfact.di.component.main

import com.fara.common_di.component.base.DIComponent
import com.fara.common_di.holder.single.FeatureComponentHolder
import dagger.Component

interface AppComponent : DIComponent

@Component
internal interface AppComponentInternal : AppComponent, AppActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponentInternal
    }
}

object AppComponentHolder : FeatureComponentHolder<AppComponent>() {

    override fun build(): AppComponent {
        return DaggerAppComponentInternal.factory().create()
    }

    internal fun getInternal(): AppComponentInternal = get() as AppComponentInternal
}
