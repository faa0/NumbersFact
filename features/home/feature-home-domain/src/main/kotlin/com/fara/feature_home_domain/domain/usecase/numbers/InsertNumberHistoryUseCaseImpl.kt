package com.fara.feature_home_domain.domain.usecase.numbers

import android.util.Log
import com.fara.feature_home_domain.data.local.mapper.domain_to_local.NumberToNumberHistoryMapper
import com.fara.feature_home_domain.data.local.repository.NumberHistoryRepository
import com.fara.feature_home_domain.domain.model.Number
import javax.inject.Inject

internal class InsertNumberHistoryUseCaseImpl @Inject constructor(
    private val repository: NumberHistoryRepository,
    private val numberToNumberHistoryMapper: NumberToNumberHistoryMapper
) : InsertNumberHistoryUseCase {

    override suspend fun invoke(number: Number) {
        repository.insertNumberHistory(numberToNumberHistoryMapper(number))
    }
}