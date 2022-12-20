package com.fara.feature_home_domain.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fara.feature_home_domain.data.local.entity.NumberHistory

@Database(
    entities = [NumberHistory::class],
    version = 1,
    exportSchema = false
)
abstract class NumbersFactDatabase: RoomDatabase() {

    abstract val numberHistoryDao: NumberHistoryDao
}
