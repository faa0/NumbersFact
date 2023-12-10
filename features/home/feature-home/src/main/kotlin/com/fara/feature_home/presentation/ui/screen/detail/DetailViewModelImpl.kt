package com.fara.feature_home.presentation.ui.screen.detail

import androidx.lifecycle.viewModelScope
import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumberHistoryByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class DetailViewModelImpl(
    private val getNumberHistoryByIdUseCase: GetNumberHistoryByIdUseCase
) : DetailViewModel() {

    override val uiState = MutableStateFlow(DetailState())

    override fun getNumberHistoryById(numberId: Int) {
        viewModelScope.launch {
            val numberHistory = getNumberHistoryByIdUseCase.invoke(numberId)
            uiState.update { it.copy(numberHistory = numberHistory) }
        }
    }
}

data class DetailState(
    val numberHistory: NumberHistory? = null,
)
