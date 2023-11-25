package com.fara.feature_home.presentation.ui.screen.home

import com.fara.core.base.BaseViewModel
import com.fara.feature_home_domain.data.local.entity.NumberHistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

internal abstract class HomeViewModel : BaseViewModel() {

    abstract val uiState: StateFlow<HomeState>

    abstract fun onNumberTextChanged(text: String)
    abstract fun getInputNumber(inputNumber: Int)
    abstract fun getRandomNumber()
    abstract fun getNumbersHistory()

    abstract fun setSnackBarVisibility(isVisible: Boolean)
}