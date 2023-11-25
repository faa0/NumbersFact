package com.fara.common_network.di.component

import com.fara.common_network.di.module.networkConfigModule
import com.fara.common_network.di.module.networkModule

val networkComponent = mutableListOf(
    networkConfigModule,
    networkModule,
)
