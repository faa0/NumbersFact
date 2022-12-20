package com.fara.common_network.di.module

import com.fara.common_network.config.NetworkConfig
import com.fara.common_network.config.NetworkConfigImpl
import dagger.Binds
import dagger.Module

@Module
internal interface ConfigModule {

    @Binds
    fun bindNetworkConfig(impl: NetworkConfigImpl): NetworkConfig
}