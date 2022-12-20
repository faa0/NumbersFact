package com.fara.feature_home.di.module

import androidx.lifecycle.ViewModel
import com.fara.common_di.utils.ViewModelKey
import com.fara.feature_home.presentation.ui.screen.detail.DetailViewModel
import com.fara.feature_home.presentation.ui.screen.detail.DetailViewModelImpl
import com.fara.feature_home.presentation.ui.screen.home.HomeViewModel
import com.fara.feature_home.presentation.ui.screen.home.HomeViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(viewModel: HomeViewModelImpl): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun bindDetailViewModel(viewModel: DetailViewModelImpl): ViewModel
}
