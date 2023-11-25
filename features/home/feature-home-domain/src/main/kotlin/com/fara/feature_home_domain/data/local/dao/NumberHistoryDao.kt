package com.fara.feature_home_domain.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fara.feature_home_domain.data.local.entity.NumberHistory
import kotlinx.coroutines.flow.Flow

@Dao
interface NumberHistoryDao {

    @Query("SELECT * FROM numbersHistory ORDER BY id DESC")
    fun getNumbersHistoryFlow(): Flow<List<NumberHistory>>

    @Query("SELECT * FROM numbersHistory WHERE id =:numberId")
    fun getNumberHistoryById(numberId: Int): NumberHistory?

    @Query("SELECT EXISTS(SELECT * FROM numbersHistory WHERE text = :text)")
    fun isNumberHistoryExist(text: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNumberHistory(numberHistory: NumberHistory)
}