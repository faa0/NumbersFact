package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.feature_home_domain.data.local.repository.NumberHistoryRepository
import kotlinx.coroutines.flow.Flow

internal class GetNumbersHistoryUseCaseImpl(
    private val repository: NumberHistoryRepository
) : GetNumbersHistoryUseCase {

    override fun invoke(): Flow<List<NumberHistory>> {
        return repository.getNumbersHistoryFlow()
    }
}