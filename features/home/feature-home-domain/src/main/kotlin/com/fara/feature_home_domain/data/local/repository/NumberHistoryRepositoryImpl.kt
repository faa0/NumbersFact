package com.fara.feature_home_domain.data.local.repository

import com.fara.feature_home_domain.data.local.dao.NumberHistoryDao
import com.fara.feature_home_domain.data.local.entity.NumberHistory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class NumberHistoryRepositoryImpl(
    private val numberHistoryDao: NumberHistoryDao
) : NumberHistoryRepository {

    override fun getNumbersHistoryFlow(): Flow<List<NumberHistory>> {
        return numberHistoryDao.getNumbersHistoryFlow()
    }

    override suspend fun getNumberHistoryById(numberId: Int): NumberHistory? {
        return withContext(Dispatchers.IO) {
            numberHistoryDao.getNumberHistoryById(numberId)
        }
    }

    override suspend fun isNumberHistoryExist(text: String): Boolean {
        return withContext(Dispatchers.IO) {
            numberHistoryDao.isNumberHistoryExist(text)
        }
    }

    override suspend fun insertNumberHistory(numberHistory: NumberHistory) {
        return withContext(Dispatchers.IO) {
            numberHistoryDao.insertNumberHistory(numberHistory)
        }
    }
}