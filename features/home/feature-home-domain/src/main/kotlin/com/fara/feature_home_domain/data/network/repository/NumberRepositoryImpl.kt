package com.fara.feature_home_domain.data.network.repository

import com.fara.common_network.utils.safeApiCall
import com.fara.common_utils.utils.ResultState
import com.fara.feature_home_domain.data.network.api.HomeApi
import com.fara.feature_home_domain.data.network.mapper.remote_to_domain.NumberResponseToNumberMapper
import com.fara.feature_home_domain.domain.model.Number
import javax.inject.Inject

internal class NumberRepositoryImpl @Inject constructor(
    private val homeApi: HomeApi,
    private val numberResponseToNumberMapper: NumberResponseToNumberMapper
) : NumberRepository {

    override suspend fun getInputNumber(inputNumber: Int): ResultState<Number> {
        return safeApiCall {
            ResultState.Success(homeApi.getInputNumber(inputNumber).run(numberResponseToNumberMapper))
        }
    }

    override suspend fun getRandomNumber(): ResultState<Number> {
        return safeApiCall {
            ResultState.Success(homeApi.getRandomNumber().run(numberResponseToNumberMapper))
        }
    }
}