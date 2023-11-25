package com.fara.feature_home_domain.di.module

import androidx.room.Room
import com.fara.feature_home_domain.data.local.dao.NumbersFactDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

internal val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            NumbersFactDatabase::class.java,
            "numbers_fact_db" //TODO move to constants
        ).build()
    }

    single { get<NumbersFactDatabase>().numberHistoryDao }
}