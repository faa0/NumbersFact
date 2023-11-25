package com.fara.feature_home_domain.di.module

import com.fara.feature_home_domain.data.local.mapper.domain_to_local.NumberToNumberHistoryMapper
import org.koin.dsl.module

internal val localMapperModule = module {
    factory { NumberToNumberHistoryMapper() }
}