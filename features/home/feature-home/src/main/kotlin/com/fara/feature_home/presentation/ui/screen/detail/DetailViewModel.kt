package com.fara.feature_home.presentation.ui.screen.detail

import com.fara.common_utils.utils.ResultState
import com.fara.core.base.BaseViewModel
import com.fara.feature_home_domain.data.local.entity.NumberHistory
import kotlinx.coroutines.flow.StateFlow

internal abstract class DetailViewModel : BaseViewModel() {

    abstract val uiState: StateFlow<ResultState<Unit>>

    abstract val numberHistoryFlow: StateFlow<NumberHistory?>

    abstract fun getNumberHistoryById(numberId: Int)
}