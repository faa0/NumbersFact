package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.domain.model.Number

interface InsertNumberHistoryUseCase {

    suspend fun invoke(number: Number)
}