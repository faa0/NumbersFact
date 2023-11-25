package com.fara.common_network.di.module

import com.fara.common_network.config.NetworkConfig
import com.fara.common_network.config.NetworkConfigImpl
import org.koin.dsl.module

internal val networkConfigModule = module {
    factory<NetworkConfig> { NetworkConfigImpl() }
}