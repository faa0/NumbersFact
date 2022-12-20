package com.fara.feature_home.presentation.ui.screen.home

import androidx.lifecycle.viewModelScope
import com.fara.common_utils.utils.ResultState
import com.fara.common_utils.utils.fold
import com.fara.core.utils.constants.Empty
import com.fara.feature_home_domain.domain.model.Number
import com.fara.feature_home_domain.domain.usecase.numbers.GetInputNumberUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumbersHistoryUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetRandomNumberUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.InsertNumberHistoryUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.IsNumberHistoryExistUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.NumberMatchesFormatUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class HomeViewModelImpl @Inject constructor(
    private val getInputNumberUseCase: GetInputNumberUseCase,
    private val getRandomNumberUseCase: GetRandomNumberUseCase,
    private val insertNumberHistoryUseCase: InsertNumberHistoryUseCase,
    getNumbersHistoryUseCase: GetNumbersHistoryUseCase,
    private val isNumberHistoryExistUseCase: IsNumberHistoryExistUseCase,
    private val numberMatchesFormatUseCase: NumberMatchesFormatUseCase
) : HomeViewModel() {

    override val uiState = MutableStateFlow<ResultState<Unit>>(ResultState.Loading(false))

    override val numberInputFlow = MutableStateFlow<String?>(null)
    override val numbersHistoryFlow = getNumbersHistoryUseCase.invoke()
    override val isSnackbarVisibleFlow = MutableStateFlow(false)

    override fun onNumberTextChanged(text: String) {
        numberInputFlow.value = text
    }

    override fun getInputNumber(inputNumber: Int) {
        val isNumberFormatValid = numberMatchesFormatUseCase.invoke(inputNumber)
        isSnackbarVisibleFlow.value = !isNumberFormatValid
        if (!isNumberFormatValid) return
        uiState.value = ResultState.Loading(true)
        viewModelScope.launch {
            getInputNumberUseCase.invoke(inputNumber).fold(
                onSuccess = { number ->
                    insertNumberHistory(number)
                    uiState.value = ResultState.Loading(false)
                },
                onError = { code, message -> uiState.value = ResultState.Error(code, message) },
                onFailure = { throwable -> uiState.value = ResultState.Failure(throwable) }
            )
        }
    }

    override fun getRandomNumber() {
        uiState.value = ResultState.Loading(true)
        viewModelScope.launch {
            getRandomNumberUseCase.invoke().fold(
                onSuccess = { number ->
                    insertNumberHistory(number)
                    uiState.value = ResultState.Loading(false)
                },
                onError = { code, message -> uiState.value = ResultState.Error(code, message) },
                onFailure = { throwable -> uiState.value = ResultState.Failure(throwable) }
            )
        }
    }

    override fun setSnackBarVisibility(isVisible: Boolean) {
        isSnackbarVisibleFlow.value = isVisible
    }

    private fun insertNumberHistory(number: Number) {
        viewModelScope.launch() {
            val isNumberHistoryExist = isNumberHistoryExistUseCase.invoke(number.text)
            if (!isNumberHistoryExist) insertNumberHistoryUseCase.invoke(number)
        }
    }
}