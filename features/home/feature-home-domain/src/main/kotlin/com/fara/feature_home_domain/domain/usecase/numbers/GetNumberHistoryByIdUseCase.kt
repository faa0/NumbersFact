package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.local.entity.NumberHistory

interface GetNumberHistoryByIdUseCase {

    suspend fun invoke(numberId: Int): NumberHistory?
}