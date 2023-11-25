package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.domain.model.Number

interface GetInputNumberUseCase {

    suspend fun invoke(inputNumber: Int): Result<Number>
}