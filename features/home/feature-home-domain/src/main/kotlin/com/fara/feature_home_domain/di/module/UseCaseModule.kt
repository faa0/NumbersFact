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
import org.koin.dsl.module

internal val useCaseModule = module {
    factory<GetInputNumberUseCase> { GetInputNumberUseCaseImpl(get()) }

    factory<GetRandomNumberUseCase> { GetRandomNumberUseCaseImpl(get()) }

    factory<GetNumberHistoryByIdUseCase> { GetNumberHistoryByIdUseCaseImpl(get()) }

    factory<GetNumbersHistoryUseCase> { GetNumbersHistoryUseCaseImpl(get()) }

    factory<InsertNumberHistoryUseCase> { InsertNumberHistoryUseCaseImpl(get(), get()) }

    factory<IsNumberHistoryExistUseCase> { IsNumberHistoryExistUseCaseImpl(get()) }

    factory<NumberMatchesFormatUseCase> { NumberMatchesFormatUseCaseImpl() }
}