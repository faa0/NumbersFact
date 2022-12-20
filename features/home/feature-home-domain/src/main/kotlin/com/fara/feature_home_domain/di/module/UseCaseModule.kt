package com.fara.feature_home_domain.di.module

import com.fara.feature_home_domain.domain.usecase.numbers.GetInputNumberUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetInputNumberUseCaseImpl
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumberHistoryByIdUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumberHistoryByIdUseCaseImpl
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumbersHistoryUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumbersHistoryUseCaseImpl
import com.fara.feature_home_domain.domain.usecase.numbers.GetRandomNumberUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetRandomNumberUseCaseImpl
import com.fara.feature_home_domain.domain.usecase.numbers.InsertNumberHistoryUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.InsertNumberHistoryUseCaseImpl
import com.fara.feature_home_domain.domain.usecase.numbers.IsNumberHistoryExistUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.IsNumberHistoryExistUseCaseImpl
import com.fara.feature_home_domain.domain.usecase.numbers.NumberMatchesFormatUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.NumberMatchesFormatUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface UseCaseModule {

    @Binds
    fun getInputNumberUseCase(impl: GetInputNumberUseCaseImpl): GetInputNumberUseCase

    @Binds
    fun getRandomNumberUseCase(impl: GetRandomNumberUseCaseImpl): GetRandomNumberUseCase

    @Binds
    fun getNumberHistoryByIdUseCase(impl: GetNumberHistoryByIdUseCaseImpl): GetNumberHistoryByIdUseCase

    @Binds
    fun getNumbersHistoryUseCase(impl: GetNumbersHistoryUseCaseImpl): GetNumbersHistoryUseCase

    @Binds
    fun insertNumberHistoryUseCase(impl: InsertNumberHistoryUseCaseImpl): InsertNumberHistoryUseCase

    @Binds
    fun isNumberHistoryExistUseCase(impl: IsNumberHistoryExistUseCaseImpl): IsNumberHistoryExistUseCase

    @Binds
    fun numberMatchesFormatUseCase(impl: NumberMatchesFormatUseCaseImpl): NumberMatchesFormatUseCase
}