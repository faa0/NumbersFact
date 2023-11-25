package com.fara.feature_home_domain.data.local.mapper.domain_to_local

import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.feature_home_domain.domain.model.Number

internal class NumberToNumberHistoryMapper: (Number) -> NumberHistory {

    override fun invoke(number: Number): NumberHistory {
        return NumberHistory(
            number = number.number,
            text = number.text
        )
    }
}