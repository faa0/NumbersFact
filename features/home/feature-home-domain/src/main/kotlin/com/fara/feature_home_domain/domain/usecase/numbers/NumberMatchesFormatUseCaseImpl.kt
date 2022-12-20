package com.fara.feature_home_domain.domain.usecase.numbers

import javax.inject.Inject

internal class NumberMatchesFormatUseCaseImpl @Inject constructor() : NumberMatchesFormatUseCase {

    override fun invoke(number: Int): Boolean {
        return number in NUMBER_VALID_DIAPASON
    }

    private companion object {
        val NUMBER_VALID_DIAPASON = 0..9999
    }
}