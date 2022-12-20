package com.fara.feature_home_domain.di.module

import android.content.Context
import androidx.room.Room
import com.fara.feature_home_domain.data.local.dao.NumberHistoryDao
import com.fara.feature_home_domain.data.local.dao.NumbersFactDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
internal class DatabaseModule {

    @Reusable
    @Provides
    fun provideNumberFactDatabase(context: Context): NumbersFactDatabase {
        return Room.databaseBuilder(
            context,
            NumbersFactDatabase::class.java,
            "numbers_fact_db" //TODO move to constants
        ).build()
    }

    @Reusable
    @Provides
    fun provideNumberHistoryDao(numbersFactDatabase: NumbersFactDatabase): NumberHistoryDao {
        return numbersFactDatabase.numberHistoryDao
    }
}