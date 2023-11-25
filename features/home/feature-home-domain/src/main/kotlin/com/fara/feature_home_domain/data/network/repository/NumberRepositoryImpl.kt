package com.fara.feature_home_domain.data.network.repository

import com.fara.common_network.utils.safeApiCall
import com.fara.feature_home_domain.data.network.api.HomeApi
import com.fara.feature_home_domain.data.network.mapper.remote_to_domain.NumberResponseToNumberMapper
import com.fara.feature_home_domain.domain.model.Number

internal class NumberRepositoryImpl(
    private val homeApi: HomeApi,
    private val numberResponseToNumberMapper: NumberResponseToNumberMapper
) : NumberRepository {

    override suspend fun getInputNumber(inputNumber: Int): Result<Number> {
        return safeApiCall {
            Result.success(homeApi.getInputNumber(inputNumber).run(numberResponseToNumberMapper))
        }
    }

    override suspend fun getRandomNumber(): Result<Number> {
        return safeApiCall {
            Result.success(homeApi.getRandomNumber().run(numberResponseToNumberMapper))
        }
    }
}