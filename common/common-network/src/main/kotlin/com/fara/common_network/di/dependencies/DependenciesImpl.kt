package com.fara.common_network.di.dependencies

import android.content.Context
import com.fara.common_di.component.app.ApplicationComponentHolder
import com.fara.common_network.di.component.NetworkComponentInternal

internal class DependenciesImpl : NetworkComponentInternal.Dependencies {

    override val context: Context
        get() = ApplicationComponentHolder.get().context()
}