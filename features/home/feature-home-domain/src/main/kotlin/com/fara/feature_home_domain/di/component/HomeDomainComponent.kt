package com.fara.feature_home_domain.di.component

import android.content.Context
import com.fara.common_di.component.base.DIComponent
import com.fara.common_di.holder.single.FeatureComponentHolder
import com.fara.feature_home_domain.di.dependencies.DependenciesImpl
import com.fara.feature_home_domain.di.module.DatabaseModule
import com.fara.feature_home_domain.di.module.NetworkModule
import com.fara.feature_home_domain.di.module.RepositoryModule
import com.fara.feature_home_domain.di.module.UseCaseModule
import com.fara.feature_home_domain.domain.usecase.numbers.GetInputNumberUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumberHistoryByIdUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumbersHistoryUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetRandomNumberUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.InsertNumberHistoryUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.IsNumberHistoryExistUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.NumberMatchesFormatUseCase
import dagger.Component
import retrofit2.Retrofit

interface HomeDomainComponent : DIComponent {

    fun getInputNumberUseCase(): GetInputNumberUseCase
    fun getRandomNumberUseCase(): GetRandomNumberUseCase
    fun getNumberHistoryByIdUseCase(): GetNumberHistoryByIdUseCase
    fun getNumbersHistoryUseCase(): GetNumbersHistoryUseCase
    fun insertNumberHistoryUseCase(): InsertNumberHistoryUseCase
    fun isNumberHistoryExistUseCase(): IsNumberHistoryExistUseCase
    fun numberMatchesFormatUseCase(): NumberMatchesFormatUseCase
}

@Component(
    modules = [
        NetworkModule::class,
        DatabaseModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ],
    dependencies = [
        HomeDomainComponentInternal.Dependencies::class,
    ]
)
internal interface HomeDomainComponentInternal : HomeDomainComponent {

    interface Dependencies {
        val context: Context
        val retrofit: Retrofit
    }

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: Dependencies
        ): HomeDomainComponentInternal
    }
}

object HomeDomainComponentHolder : FeatureComponentHolder<HomeDomainComponent>() {

    override fun build(): HomeDomainComponent {
        return DaggerHomeDomainComponentInternal.factory().create(DependenciesImpl())
    }

    internal fun getInternal(): HomeDomainComponentInternal = get() as HomeDomainComponentInternal
}
