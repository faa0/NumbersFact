package com.fara.feature_home.presentation.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.fara.common_di.utils.getDaggerViewModel
import com.fara.common_utils.utils.ResultState
import com.fara.core.utils.constants.Empty
import com.fara.feature_home.di.component.HomeComponentHolder
import com.fara.feature_home.presentation.ui.screen.detail.DetailScreen
import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.ui_components.compose.theme.DefaultTheme
import com.fara.ui_components.compose.view.NumberTextField
import com.fara.ui_components.compose.view.RoundedButton
import com.fara.ui_components.utils.UIString
import javax.inject.Inject

internal class HomeScreen : AndroidScreen() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Composable
    override fun Content() {
        HomeComponentHolder.getInternal().inject(this)

        DefaultTheme() {
            Screen()
        }
    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    private fun Screen() {
        val viewModel: HomeViewModel = getDaggerViewModel(viewModelProviderFactory = viewModelFactory)
        val localNavigator = LocalNavigator.currentOrThrow
        val keyboardController = LocalSoftwareKeyboardController.current
        val focusManager = LocalFocusManager.current

        val uiState = viewModel.uiState.collectAsState()
        val numberInputFlow = viewModel.numberInputFlow.collectAsState()
        val numbersHistory = viewModel.numbersHistoryFlow.collectAsState(emptyList())
        val isSnackbarVisible = viewModel.isSnackbarVisibleFlow.collectAsState()

        val listState = rememberLazyListState()

        when (val uiStateValue = uiState.value) {
            is ResultState.Loading -> {
                if (uiStateValue.state) {
                    //TODO need to add loader
                } else {
                    val numberInputFlowNotNullable = numberInputFlow.value ?: Empty.STRING
                    ScreenContent(numberInputFlow = numberInputFlowNotNullable,
                        numbersHistory = numbersHistory.value,
                        isSnackbarVisible = isSnackbarVisible.value,
                        listState = listState,
                        onNumberChanged = viewModel::onNumberTextChanged,
                        onClickInputNumber = {
                            hideKeyboard(keyboardController, focusManager)
                            viewModel.getInputNumber(numberInputFlowNotNullable.toInt())
                        },
                        onClickRandomNumber = {
                            hideKeyboard(keyboardController, focusManager)
                            viewModel.getRandomNumber()
                        },
                        onClickNumberItem = { numberId -> localNavigator.push(DetailScreen(numberId)) },
                        onClickSnackbar = { viewModel.setSnackBarVisibility(false) })
                }
            }
            is ResultState.Error -> {
                //TODO need to add error view
            }
            is ResultState.Failure -> {
                //TODO need to add failure view
            }
            is ResultState.Success -> Unit
        }
    }

    @Composable
    private fun ScreenContent(
        numberInputFlow: String,
        numbersHistory: List<NumberHistory>,
        isSnackbarVisible: Boolean,
        listState: LazyListState,
        onNumberChanged: (String) -> Unit,
        onClickInputNumber: () -> Unit,
        onClickRandomNumber: () -> Unit,
        onClickNumberItem: (Int) -> Unit,
        onClickSnackbar: () -> Unit
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column() {
                NumberTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    value = numberInputFlow,
                    onTextChanged = onNumberChanged
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    RoundedButton(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp),
                        stringResId = UIString.fragment_main_get_fact,
                        isEnabled = numberInputFlow.isNotBlank(),
                        onClick = onClickInputNumber
                    )
                    RoundedButton(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp),
                        stringResId = UIString.fragment_main_get_random_fact,
                        onClick = onClickRandomNumber
                    )
                }
                NumbersList(numbersList = numbersHistory,
                    listState = listState,
                    onItemClick = { numberId -> onClickNumberItem(numberId) })
            }
            if (isSnackbarVisible) {
                RoundedSnackbar(
                    modifier = Modifier.align(Alignment.BottomCenter), onClickSnackbar = onClickSnackbar
                )
            }
        }
    }

    @Composable
    private fun NumbersList(
        modifier: Modifier = Modifier,
        numbersList: List<NumberHistory>,
        listState: LazyListState,
        onItemClick: (Int) -> Unit
    ) {
        LazyColumn(
            modifier = Modifier.then(modifier), state = listState, content = {
                items(items = numbersList, key = { item -> item.id }) { data ->
                    NumberItem(text = data.text, onItemClick = { onItemClick(data.id) })
                }
            }, verticalArrangement = Arrangement.spacedBy(8.dp)
        )
        LaunchedEffect(key1 = numbersList) {
            listState.animateScrollToItem(0)
        }
    }

    @Composable
    private fun NumberItem(
        modifier: Modifier = Modifier, text: String, onItemClick: () -> Unit
    ) {
        Row(modifier = Modifier
            .then(modifier)
            .fillMaxWidth()
            .clickable { onItemClick.invoke() }) {
            Text(
                modifier = Modifier, text = text, color = MaterialTheme.colors.onError
            )
        }
    }

    @Composable
    private fun RoundedSnackbar(
        modifier: Modifier = Modifier, onClickSnackbar: () -> Unit
    ) {
        Snackbar(modifier = Modifier.then(modifier), content = {
            Text(
                text = stringResource(id = UIString.fragment_main_number_error),
                color = MaterialTheme.colors.onBackground
            )
        }, backgroundColor = MaterialTheme.colors.primary, shape = RoundedCornerShape(100.dp), action = {
            ClickableText(text = AnnotatedString(text = stringResource(id = android.R.string.ok)),
                style = MaterialTheme.typography.button.copy(color = MaterialTheme.colors.onBackground),
                onClick = { onClickSnackbar.invoke() })
        })
    }

    @OptIn(ExperimentalComposeUiApi::class)
    private fun hideKeyboard(keyboardController: SoftwareKeyboardController?, focusManager: FocusManager) {
        keyboardController?.hide()
        focusManager.clearFocus()
    }
}