package presentation.ui.screen.home

import com.fara.feature_home.presentation.ui.screen.home.HomeViewModel
import com.fara.feature_home.presentation.ui.screen.home.HomeViewModelImpl
import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.feature_home_domain.domain.model.Number
import com.fara.feature_home_domain.domain.usecase.numbers.GetInputNumberUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumbersHistoryUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.GetRandomNumberUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.InsertNumberHistoryUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.IsNumberHistoryExistUseCase
import com.fara.feature_home_domain.domain.usecase.numbers.NumberMatchesFormatUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    private val getInputNumberUseCase = mock<GetInputNumberUseCase>()
    private val getRandomNumberUseCase = mock<GetRandomNumberUseCase>()
    private val insertNumberHistoryUseCase = mock<InsertNumberHistoryUseCase>()
    private val getNumberHistoryUseCase = mock<GetNumbersHistoryUseCase>()
    private val isNumberHistoryExistUseCase = mock<IsNumberHistoryExistUseCase>()
    private val numberMatchesFormatUseCase = mock<NumberMatchesFormatUseCase>()

    private lateinit var viewModel: HomeViewModel

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        `when`(getNumberHistoryUseCase.invoke()).thenReturn(emptyFlow())
        viewModel = HomeViewModelImpl(
            getInputNumberUseCase,
            getRandomNumberUseCase,
            insertNumberHistoryUseCase,
            getNumberHistoryUseCase,
            isNumberHistoryExistUseCase,
            numberMatchesFormatUseCase
        )
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getRandomNumber should set Loading state to true and then false on success`() {
        runTest {
            val number = Number(0, "test")
            `when`(getRandomNumberUseCase.invoke()).thenReturn(Result.success(number))
            `when`(isNumberHistoryExistUseCase.invoke(anyString())).thenReturn(true)

            viewModel.getRandomNumber()

            val expectedStart = true
            val actualStart = viewModel.uiState.value.isLoading
            Assertions.assertEquals(expectedStart, actualStart)
            testDispatcher.scheduler.advanceUntilIdle()
            val expectedFinish = false
            val actualFinish = viewModel.uiState.value.isLoading
            Assertions.assertEquals(expectedFinish, actualFinish)
        }
    }

    @Test
    fun `getRandomNumber should set isInsertDataExist to true and don't insert the data`() {
        runTest {
            val number = Number(0, "test")
            `when`(getRandomNumberUseCase.invoke()).thenReturn(Result.success(number))
            `when`(isNumberHistoryExistUseCase.invoke(anyString())).thenReturn(true)

            viewModel.getRandomNumber()

            testDispatcher.scheduler.advanceUntilIdle()
            verify(isNumberHistoryExistUseCase).invoke(anyString())
        }
    }

    @Test
    fun `getRandomNumber should set isInsertDataExist to false and insert the data`() {
        runTest {
            val number = Number(0, "test")
            `when`(getRandomNumberUseCase.invoke()).thenReturn(Result.success(number))
            `when`(isNumberHistoryExistUseCase.invoke(anyString())).thenReturn(false)
            `when`(insertNumberHistoryUseCase.invoke(number)).thenReturn(Unit)

            viewModel.getRandomNumber()

            testDispatcher.scheduler.advanceUntilIdle()
            verify(insertNumberHistoryUseCase).invoke(number)
        }
    }

    @Test
    fun `getRandomNumber should set Failure state on exception`() {
        runTest {
            val expected = Throwable()
            `when`(getRandomNumberUseCase.invoke()).thenReturn(Result.failure(expected))

            viewModel.getRandomNumber()

            testDispatcher.scheduler.advanceUntilIdle()
            val actual = viewModel.uiState.value.error
            Assertions.assertEquals(expected, actual)
        }
    }

    @Test
    fun `getInputNumber should set snack bar state to false when number format is invalid`() {
        runTest {
            `when`(numberMatchesFormatUseCase.invoke(anyInt())).thenReturn(false)

            viewModel.getInputNumber(anyInt())

            val expected = true
            val actual = viewModel.uiState.value.isSnackBarVisible
            Assertions.assertEquals(expected, actual)
        }
    }

    @Test
    fun `getInputNumber should set false when number format is invalid`() {
        runTest {
            val number = Number(0, "test")
            `when`(numberMatchesFormatUseCase.invoke(anyInt())).thenReturn(false)
            `when`(getInputNumberUseCase.invoke(anyInt())).thenReturn(Result.success(number))

            viewModel.getInputNumber(anyInt())

            testDispatcher.scheduler.advanceUntilIdle()
            verify(getInputNumberUseCase, never()).invoke(anyInt())
        }
    }

    @Test
    fun `getInputNumber should set Loading state to true and then false on success`() {
        runTest {
            val number = Number(0, "test")
            `when`(numberMatchesFormatUseCase.invoke(anyInt())).thenReturn(true)
            `when`(getInputNumberUseCase.invoke(anyInt())).thenReturn(Result.success(number))
            `when`(isNumberHistoryExistUseCase.invoke(anyString())).thenReturn(true)

            viewModel.getInputNumber(anyInt())

            val expectedStart = true
            val actualStart = viewModel.uiState.value.isLoading
            Assertions.assertEquals(expectedStart, actualStart)
            testDispatcher.scheduler.advanceUntilIdle()
            val expectedFinish = false
            val actualFinish = viewModel.uiState.value.isLoading
            Assertions.assertEquals(expectedFinish, actualFinish)
        }
    }

    @Test
    fun `getInputNumber should set isInsertDataExist to true and don't insert the data`() {
        runTest {
            val number = Number(0, "test")
            `when`(numberMatchesFormatUseCase.invoke(anyInt())).thenReturn(true)
            `when`(getInputNumberUseCase.invoke(anyInt())).thenReturn(Result.success(number))
            `when`(isNumberHistoryExistUseCase.invoke(anyString())).thenReturn(true)

            viewModel.getInputNumber(anyInt())

            testDispatcher.scheduler.advanceUntilIdle()
            verify(isNumberHistoryExistUseCase).invoke(anyString())
        }
    }

    @Test
    fun `getInputNumber should set Failure state on exception`() {
        runTest {
            val expected = Throwable()
            `when`(numberMatchesFormatUseCase.invoke(anyInt())).thenReturn(true)
            `when`(getInputNumberUseCase.invoke(anyInt())).thenReturn(Result.failure(expected))

            viewModel.getInputNumber(anyInt())

            testDispatcher.scheduler.advanceUntilIdle()
            val actual = viewModel.uiState.value.error
            Assertions.assertEquals(expected, actual)
        }
    }

    @Test
    fun `getNumbersHistoryUseCase should get a list`() {
        runTest {
            val expected = listOf(NumberHistory(number = 0, text = "test"))
            `when`(getNumberHistoryUseCase.invoke()).thenReturn(flowOf(expected))

            viewModel.getNumbersHistory()

            testDispatcher.scheduler.advanceUntilIdle()
            val actual = viewModel.uiState.value.numberHistory
            Assertions.assertEquals(expected, actual)
        }
    }

    @Test
    fun `onNumberTextChanged should set a value`() {
        val expected = "test"

        viewModel.onNumberTextChanged(expected)

        val actual = viewModel.uiState.value.numberInput
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `setSnackBarVisibility should set isSnackBarVisible state to true`() {
        val expected = true

        viewModel.setSnackBarVisibility(true)

        val actual = viewModel.uiState.value.isSnackBarVisible
        Assertions.assertEquals(expected, actual)
    }
}