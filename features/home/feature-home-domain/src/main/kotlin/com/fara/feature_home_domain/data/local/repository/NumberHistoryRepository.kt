package com.fara.feature_home_domain.data.local.repository

import com.fara.feature_home_domain.data.local.entity.NumberHistory
import kotlinx.coroutines.flow.Flow

interface NumberHistoryRepository {

    fun getNumbersHistoryFlow(): Flow<List<NumberHistory>>

    suspend fun getNumberHistoryById(numberId: Int): NumberHistory?

    suspend fun isNumberHistoryExist(text: String): Boolean

    suspend fun insertNumberHistory(numberHistory: NumberHistory)
}