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
import cafe.adriel.voyager.androidx.AndroidScreen
import com.fara.core.utils.constants.Empty
import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.ui_components.compose.theme.DefaultTheme
import org.koin.androidx.compose.koinViewModel

internal class DetailScreen(
    private val numberId: Int
) : AndroidScreen() {

    @Composable
    override fun Content() {
        DefaultTheme {
            Screen()
        }
    }

    @Composable
    private fun Screen() {
        val viewModel = koinViewModel<DetailViewModel>()
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