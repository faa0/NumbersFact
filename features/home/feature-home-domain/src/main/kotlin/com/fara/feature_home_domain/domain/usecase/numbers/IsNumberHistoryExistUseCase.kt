package com.fara.feature_home_domain.domain.usecase.numbers

interface IsNumberHistoryExistUseCase {

    suspend fun invoke(text: String): Boolean
}