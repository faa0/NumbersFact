package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.local.entity.NumberHistory
import kotlinx.coroutines.flow.Flow

interface GetNumbersHistoryUseCase {

    fun invoke(): Flow<List<NumberHistory>>
}