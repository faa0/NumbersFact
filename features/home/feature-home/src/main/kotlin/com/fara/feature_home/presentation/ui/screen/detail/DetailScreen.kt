package com.fara.feature_home.presentation.ui.screen.detail

import androidx.annotation.ColorRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import cafe.adriel.voyager.androidx.AndroidScreen
import com.fara.common_di.utils.getDaggerViewModel
import com.fara.core.utils.constants.Empty
import com.fara.feature_home.di.component.HomeComponentHolder
import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.ui_components.compose.theme.DefaultTheme
import javax.inject.Inject

internal class DetailScreen(
    private val numberId: Int
) : AndroidScreen() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Composable
    override fun Content() {
        HomeComponentHolder.getInternal().inject(this)

        DefaultTheme {
            Screen()
        }
    }

    @Composable
    private fun Screen() {
        val viewModel: DetailViewModel = getDaggerViewModel(viewModelProviderFactory = viewModelFactory)
        val numberHistoryFlow = viewModel.numberHistoryFlow.collectAsState()

        LaunchedEffect(key1 = Unit) {
            viewModel.getNumberHistoryById(numberId)
        }

        ScreenContent(
            number = numberHistoryFlow.value
        )
    }

    @Composable
    private fun ScreenContent(number: NumberHistory?) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            HeaderText(
                modifier = Modifier.padding(bottom = 16.dp),
                text = number?.text ?: Empty.STRING,
                textColor = MaterialTheme.colors.error
            )
        }
    }

    @Composable
    private fun HeaderText(
        modifier: Modifier = Modifier,
        text: String,
        @ColorRes textColor: Color
    ) {
        Text(
            modifier = Modifier.then(modifier),
            text = text,
            color = textColor
        )
    }
}