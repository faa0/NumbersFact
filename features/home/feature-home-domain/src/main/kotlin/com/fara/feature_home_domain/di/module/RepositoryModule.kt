package com.fara.feature_home_domain.di.module

import com.fara.feature_home_domain.data.local.repository.NumberHistoryRepository
import com.fara.feature_home_domain.data.local.repository.NumberHistoryRepositoryImpl
import com.fara.feature_home_domain.data.network.repository.NumberRepository
import com.fara.feature_home_domain.data.network.repository.NumberRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoryModule {

    @Binds
    fun bindNumberRepository(impl: NumberRepositoryImpl): NumberRepository

    @Binds
    fun bindNumberHistoryRepository(impl: NumberHistoryRepositoryImpl): NumberHistoryRepository
}