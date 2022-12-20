package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.common_utils.utils.ResultState
import com.fara.feature_home_domain.domain.model.Number

interface GetRandomNumberUseCase {

    suspend fun invoke(): ResultState<Number>
}