package com.fara.feature_home.di.module

import com.fara.feature_home.presentation.ui.screen.detail.DetailViewModel
import com.fara.feature_home.presentation.ui.screen.detail.DetailViewModelImpl
import com.fara.feature_home.presentation.ui.screen.home.HomeViewModel
import com.fara.feature_home.presentation.ui.screen.home.HomeViewModelImpl
import org.koin.dsl.module

internal val viewModelModule = module {
    factory<HomeViewModel> {
        HomeViewModelImpl(get(), get(), get(), get(), get(), get())
    }

    factory<DetailViewModel> {
        DetailViewModelImpl(get())
    }
}
