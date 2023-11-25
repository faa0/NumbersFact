package com.fara.feature_home.di.component

import com.fara.feature_home.di.module.viewModelModule
import com.fara.feature_home_domain.di.component.homeDomainComponent
import org.koin.core.module.Module

val homeComponent = mutableListOf<Module>().apply {
    addAll(homeDomainComponent)
    add(viewModelModule)
}