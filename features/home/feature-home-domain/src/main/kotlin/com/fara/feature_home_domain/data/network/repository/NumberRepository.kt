package com.fara.feature_home_domain.data.network.repository

import com.fara.common_utils.utils.ResultState
import com.fara.feature_home_domain.domain.model.Number

interface NumberRepository {

    suspend fun getInputNumber(inputNumber: Int): ResultState<Number>

    suspend fun getRandomNumber(): ResultState<Number>
}