package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.feature_home_domain.data.local.repository.NumberHistoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetNumbersHistoryUseCaseImpl @Inject constructor(
    private val repository: NumberHistoryRepository
) : GetNumbersHistoryUseCase {

    override fun invoke(): Flow<List<NumberHistory>> {
        return repository.getNumbersHistoryFlow()
    }
}