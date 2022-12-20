package com.fara.feature_home_domain.domain.usecase.numbers

interface NumberMatchesFormatUseCase {

    fun invoke(number: Int): Boolean
}