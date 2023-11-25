package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.feature_home_domain.data.local.repository.NumberHistoryRepository

internal class GetNumberHistoryByIdUseCaseImpl(
    private val repository: NumberHistoryRepository
): GetNumberHistoryByIdUseCase {

    override suspend fun invoke(numberId: Int): NumberHistory? {
        return repository.getNumberHistoryById(numberId)
    }
}