package com.fara.feature_home_domain.di.module

import com.fara.feature_home_domain.data.network.mapper.remote_to_domain.NumberResponseToNumberMapper
import org.koin.dsl.module

internal val remoteMapperModule = module {
    factory { NumberResponseToNumberMapper() }
}