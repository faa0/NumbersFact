package com.fara.feature_home_domain.data.network.repository

import com.fara.feature_home_domain.domain.model.Number

interface NumberRepository {

    suspend fun getInputNumber(inputNumber: Int): Result<Number>

    suspend fun getRandomNumber(): Result<Number>
}