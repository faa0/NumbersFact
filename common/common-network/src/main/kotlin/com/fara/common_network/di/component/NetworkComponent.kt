package com.fara.common_network.di.component

import android.content.Context
import com.fara.common_di.component.base.DIComponent
import com.fara.common_di.holder.single.ComponentHolder
import com.fara.common_network.di.dependencies.DependenciesImpl
import com.fara.common_network.di.module.ConfigModule
import com.fara.common_network.di.module.NetworkModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

interface NetworkComponent : DIComponent {

    fun networkClient(): Retrofit
}

@Singleton
@Component(
    modules = [
        ConfigModule::class,
        NetworkModule::class
    ],
    dependencies = [NetworkComponentInternal.Dependencies::class]
)
internal interface NetworkComponentInternal : NetworkComponent {

    interface Dependencies {
        val context: Context
    }

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: Dependencies
        ): NetworkComponentInternal
    }
}

object NetworkComponentHolder : ComponentHolder<NetworkComponent>() {

    override fun build(): NetworkComponent {
        return DaggerNetworkComponentInternal.factory().create(DependenciesImpl())
    }

    internal fun getInternal(): NetworkComponentInternal = get() as NetworkComponentInternal
}
