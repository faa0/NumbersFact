package com.fara.feature_home_domain.di.module

import com.fara.feature_home_domain.data.network.api.HomeApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
internal class NetworkModule {

    @Reusable
    @Provides
    fun provideHomeApi(retrofit: Retrofit): HomeApi {
        return retrofit.create(HomeApi::class.java)
    }
}