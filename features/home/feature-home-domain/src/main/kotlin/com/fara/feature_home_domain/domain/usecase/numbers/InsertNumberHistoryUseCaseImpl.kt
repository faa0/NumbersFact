package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.local.mapper.domain_to_local.NumberToNumberHistoryMapper
import com.fara.feature_home_domain.data.local.repository.NumberHistoryRepository
import com.fara.feature_home_domain.domain.model.Number

internal class InsertNumberHistoryUseCaseImpl(
    private val repository: NumberHistoryRepository,
    private val numberToNumberHistoryMapper: NumberToNumberHistoryMapper
) : InsertNumberHistoryUseCase {

    override suspend fun invoke(number: Number) {
        repository.insertNumberHistory(numberToNumberHistoryMapper(number))
    }
}