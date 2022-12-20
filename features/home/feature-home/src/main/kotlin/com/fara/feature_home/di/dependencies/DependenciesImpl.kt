package com.fara.feature_home.di.dependencies

import com.fara.feature_home.di.component.HomeComponentInternal
import com.fara.feature_home_domain.di.component.HomeDomainComponentHolder
import com.fara.feature_home_domain.domain.usecase.numbers.GetInputNumberUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumberHistoryByIdUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumbersHistoryUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetRandomNumberUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.InsertNumberHistoryUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.IsNumberHistoryExistUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.NumberMatchesFormatUseCase

internal class DependenciesImpl : HomeComponentInternal.Dependencies {

    override val getInputNumberUseCase: GetInputNumberUseCase
        get() = HomeDomainComponentHolder.get().getInputNumberUseCase()

    override val getRandomNumberUseCase: GetRandomNumberUseCase
        get() = HomeDomainComponentHolder.get().getRandomNumberUseCase()

    override val getNumberHistoryByIdUseCase: GetNumberHistoryByIdUseCase
        get() = HomeDomainComponentHolder.get().getNumberHistoryByIdUseCase()

    override val getNumberHistoryUseCase: GetNumbersHistoryUseCase
        get() = HomeDomainComponentHolder.get().getNumbersHistoryUseCase()

    override val insertNumberHistoryUseCase: InsertNumberHistoryUseCase
        get() = HomeDomainComponentHolder.get().insertNumberHistoryUseCase()

    override val isNumberHistoryExistUseCase: IsNumberHistoryExistUseCase
        get() = HomeDomainComponentHolder.get().isNumberHistoryExistUseCase()

    override val numberMatchesFormatUseCase: NumberMatchesFormatUseCase
        get() = HomeDomainComponentHolder.get().numberMatchesFormatUseCase()
}