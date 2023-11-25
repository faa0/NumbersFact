package com.fara.common_network.di.module

import com.fara.common_network.BuildConfig
import com.fara.common_network.config.NetworkConfig
import com.fara.common_network.utils.MoshiArrayListJsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

internal val networkModule = module {

    single {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
    }

    single {
        OkHttpClient.Builder()
            .readTimeout(get<NetworkConfig>().readTimeoutSeconds, TimeUnit.SECONDS)
            .connectTimeout(get<NetworkConfig>().connectTimeOutSeconds, TimeUnit.SECONDS)
            .writeTimeout(get<NetworkConfig>().writeTimeoutSeconds, TimeUnit.SECONDS)
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get())
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
