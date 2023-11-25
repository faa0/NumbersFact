package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.network.repository.NumberRepository
import com.fara.feature_home_domain.domain.model.Number
import javax.inject.Inject

internal class GetInputNumberUseCaseImpl @Inject constructor(
    private val repository: NumberRepository
) : GetInputNumberUseCase {

    override suspend fun invoke(inputNumber: Int): Result<Number> {
        return repository.getInputNumber(inputNumber)
    }
}