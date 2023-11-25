package com.fara.feature_home.presentation.ui.screen.home

import androidx.compose.runtime.Immutable
import androidx.lifecycle.viewModelScope
import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.feature_home_domain.domain.model.Number
import com.fara.feature_home_domain.domain.usecase.numbers.GetInputNumberUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumbersHistoryUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetRandomNumberUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.InsertNumberHistoryUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.IsNumberHistoryExistUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.NumberMatchesFormatUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class HomeViewModelImpl @Inject constructor(
    private val getInputNumberUseCase: GetInputNumberUseCase,
    private val getRandomNumberUseCase: GetRandomNumberUseCase,
    private val insertNumberHistoryUseCase: InsertNumberHistoryUseCase,
    private val getNumbersHistoryUseCase: GetNumbersHistoryUseCase,
    private val isNumberHistoryExistUseCase: IsNumberHistoryExistUseCase,
    private val numberMatchesFormatUseCase: NumberMatchesFormatUseCase
) : HomeViewModel() {

    override val uiState = MutableStateFlow(HomeState())

    override fun onNumberTextChanged(text: String) {
        uiState.update { it.copy(numberInput = text) }
    }

    override fun getInputNumber(inputNumber: Int) {
        val isNumberFormatValid = numberMatchesFormatUseCase.invoke(inputNumber)
        uiState.update { it.copy(isSnackBarVisible = !isNumberFormatValid) }
        if (!isNumberFormatValid) return
        uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            getInputNumberUseCase.invoke(inputNumber).fold(
                onSuccess = { number ->
                    insertNumberHistory(number)
                    uiState.update { it.copy(isLoading = false) }
                },
                onFailure = { throwable -> uiState.update { it.copy(error = throwable) } }
            )
        }
    }

    override fun getRandomNumber() {
        uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            getRandomNumberUseCase.invoke().fold(
                onSuccess = { number ->
                    insertNumberHistory(number)
                    uiState.update { it.copy(isLoading = false) }
                },
                onFailure = { throwable -> uiState.update { it.copy(error = throwable) } }
            )
        }
    }

    override fun getNumbersHistory() {
        viewModelScope.launch {
            getNumbersHistoryUseCase.invoke().collectLatest { list ->
                uiState.update { it.copy(numberHistory = list) }
            }
        }
    }

    override fun setSnackBarVisibility(isVisible: Boolean) {
        uiState.update { it.copy(isSnackBarVisible = isVisible) }
    }

    private fun insertNumberHistory(number: Number) {
        viewModelScope.launch {
            val isNumberHistoryExist = isNumberHistoryExistUseCase.invoke(number.text)
            if (!isNumberHistoryExist) insertNumberHistoryUseCase.invoke(number)
        }
    }
}

@Immutable
data class HomeState(
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    val numberInput: String? = null,
    val numberHistory: List<NumberHistory> = emptyList(),
    val isSnackBarVisible: Boolean = false,
)