package com.fara.feature_home_domain.di.dependencies

import android.content.Context
import com.fara.common_di.component.app.ApplicationComponentHolder
import com.fara.common_network.di.component.NetworkComponentHolder
import com.fara.feature_home_domain.di.component.HomeDomainComponentInternal
import retrofit2.Retrofit

internal class DependenciesImpl : HomeDomainComponentInternal.Dependencies {

    override val context: Context
        get() = ApplicationComponentHolder.get().context()

    override val retrofit: Retrofit
        get() = NetworkComponentHolder.get().networkClient()
}