package com.fara.common_di.module

import androidx.lifecycle.ViewModelProvider
import com.fara.common_di.utils.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface CommonDiModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
