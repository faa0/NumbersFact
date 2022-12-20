package com.fara.common_network.di.module

import com.fara.common_network.BuildConfig
import com.fara.common_network.config.NetworkConfig
import com.fara.common_network.utils.MoshiArrayListJsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
internal class NetworkModule {

    @Singleton
    @Provides
    fun provideHttpLoginInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        networkConfig: NetworkConfig
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(networkConfig.connectTimeOutSeconds, TimeUnit.SECONDS)
            .readTimeout(networkConfig.readTimeoutSeconds, TimeUnit.SECONDS)
            .writeTimeout(networkConfig.writeTimeoutSeconds, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(MoshiArrayListJsonAdapter.FACTORY)
                        .add(KotlinJsonAdapterFactory())
                        .build()
                ).asLenient()
            )
            .build()
    }
}
