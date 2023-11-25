package com.fara.feature_home_domain.di.module

import com.fara.feature_home_domain.data.network.api.HomeApi
import org.koin.dsl.module
import retrofit2.Retrofit

internal val networkModule = module {
    single { get<Retrofit>().create(HomeApi::class.java) }
}