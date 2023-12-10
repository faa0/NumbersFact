package com.fara.feature_home.presentation.ui.screen.detail

import com.fara.core.base.BaseViewModel
import kotlinx.coroutines.flow.StateFlow

internal abstract class DetailViewModel : BaseViewModel() {

    abstract val uiState: StateFlow<DetailState>

    abstract fun getNumberHistoryById(numberId: Int)
}