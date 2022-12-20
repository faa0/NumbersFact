package com.fara.feature_home.presentation.ui.screen.detail

import androidx.lifecycle.viewModelScope
import com.fara.common_utils.utils.ResultState
import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumberHistoryByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class DetailViewModelImpl @Inject constructor(
    private val getNumberHistoryByIdUseCase: GetNumberHistoryByIdUseCase
) : DetailViewModel() {

    override val uiState = MutableStateFlow<ResultState<Unit>>(ResultState.Loading(false))

    override val numberHistoryFlow = MutableStateFlow<NumberHistory?>(null)

    override fun getNumberHistoryById(numberId: Int) {
        viewModelScope.launch {
            val numberHistory = getNumberHistoryByIdUseCase.invoke(numberId)
            this@DetailViewModelImpl.numberHistoryFlow.value = numberHistory
        }
    }
}
