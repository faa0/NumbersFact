package com.fara.feature_home.di.component

import com.fara.common_di.component.base.DIComponent
import com.fara.common_di.holder.single.FeatureComponentHolder
import com.fara.common_di.module.CommonDiModule
import com.fara.feature_home.di.dependencies.DependenciesImpl
import com.fara.feature_home.di.module.ViewModelModule
import com.fara.feature_home_domain.domain.usecase.numbers.GetInputNumberUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumberHistoryByIdUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumbersHistoryUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetRandomNumberUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.InsertNumberHistoryUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.IsNumberHistoryExistUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.NumberMatchesFormatUseCase
import dagger.Component

interface HomeComponent : DIComponent

@Component(
    modules = [
        CommonDiModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        HomeComponentInternal.Dependencies::class,
    ]
)
internal interface HomeComponentInternal : HomeComponent, HomeScreenComponent {

    interface Dependencies {
        val getInputNumberUseCase: GetInputNumberUseCase
        val getRandomNumberUseCase: GetRandomNumberUseCase
        val getNumberHistoryByIdUseCase: GetNumberHistoryByIdUseCase
        val getNumberHistoryUseCase: GetNumbersHistoryUseCase
        val insertNumberHistoryUseCase: InsertNumberHistoryUseCase
        val isNumberHistoryExistUseCase: IsNumberHistoryExistUseCase
        val numberMatchesFormatUseCase: NumberMatchesFormatUseCase
    }

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: Dependencies
        ): HomeComponentInternal
    }
}

object HomeComponentHolder : FeatureComponentHolder<HomeComponent>() {

    override fun build(): HomeComponent {
        return DaggerHomeComponentInternal.factory().create(DependenciesImpl())
    }

    internal fun getInternal(): HomeComponentInternal = get() as HomeComponentInternal
}
