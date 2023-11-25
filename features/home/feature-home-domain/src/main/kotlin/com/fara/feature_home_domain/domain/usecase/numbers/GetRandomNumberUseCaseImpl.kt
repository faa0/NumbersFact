package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.network.repository.NumberRepository
import com.fara.feature_home_domain.domain.model.Number

internal class GetRandomNumberUseCaseImpl(
    private val repository: NumberRepository
) : GetRandomNumberUseCase {

    override suspend fun invoke(): Result<Number> {
        return repository.getRandomNumber()
    }
}