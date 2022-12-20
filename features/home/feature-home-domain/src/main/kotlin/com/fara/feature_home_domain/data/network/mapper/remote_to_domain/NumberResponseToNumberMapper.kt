package com.fara.feature_home_domain.data.network.mapper.remote_to_domain

import com.fara.feature_home_domain.data.network.model.response.NumberResponse
import com.fara.feature_home_domain.domain.model.Number
import javax.inject.Inject

internal class NumberResponseToNumberMapper @Inject constructor() : (NumberResponse) -> Number {

    override fun invoke(numberResponse: NumberResponse): Number {
        return Number(
            number = numberResponse.number,
            text = numberResponse.text
        )
    }
}