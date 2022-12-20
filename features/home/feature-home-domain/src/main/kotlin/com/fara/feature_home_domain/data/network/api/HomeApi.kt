package com.fara.feature_home_domain.data.network.api

import com.fara.feature_home_domain.data.network.model.response.NumberResponse
import retrofit2.http.GET
import retrofit2.http.Path

internal interface HomeApi {

    @GET(HomeNetwork.GET_INPUT_NUMBER)
    suspend fun getInputNumber(
        @Path("inputNumber") inputNumber: Int
    ): NumberResponse

    @GET(HomeNetwork.GET_RANDOM_NUMBER)
    suspend fun getRandomNumber(): NumberResponse
}