package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.local.repository.NumberHistoryRepository

internal class IsNumberHistoryExistUseCaseImpl(
    private val repository: NumberHistoryRepository
) : IsNumberHistoryExistUseCase {

    override suspend fun invoke(text: String): Boolean {
        return repository.isNumberHistoryExist(text)
    }
}