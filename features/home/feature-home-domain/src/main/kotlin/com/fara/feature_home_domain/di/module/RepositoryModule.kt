package com.fara.feature_home_domain.di.module

import com.fara.feature_home_domain.data.local.repository.NumberHistoryRepository
import com.fara.feature_home_domain.data.local.repository.NumberHistoryRepositoryImpl
import com.fara.feature_home_domain.data.network.repository.NumberRepository
import com.fara.feature_home_domain.data.network.repository.NumberRepositoryImpl
import org.koin.dsl.module

internal val repositoryModule = module {
    factory<NumberRepository> { NumberRepositoryImpl(get(), get()) }

    factory<NumberHistoryRepository> { NumberHistoryRepositoryImpl(get()) }
}