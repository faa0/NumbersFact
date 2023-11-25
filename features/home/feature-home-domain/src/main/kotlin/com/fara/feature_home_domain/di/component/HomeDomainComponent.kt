package com.fara.feature_home_domain.di.component

import com.fara.common_network.di.component.networkComponent
import com.fara.feature_home_domain.di.module.databaseModule
import com.fara.feature_home_domain.di.module.localMapperModule
import com.fara.feature_home_domain.di.module.networkModule
import com.fara.feature_home_domain.di.module.remoteMapperModule
import com.fara.feature_home_domain.di.module.repositoryModule
import com.fara.feature_home_domain.di.module.useCaseModule
import org.koin.core.module.Module

val homeDomainComponent = mutableListOf<Module>().apply {
    addAll(networkComponent)
    add(databaseModule)
    add(localMapperModule)
    add(networkModule)
    add(remoteMapperModule)
    add(repositoryModule)
    add(useCaseModule)
}
