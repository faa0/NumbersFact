package presentation.ui.screen.detail

import com.fara.feature_home.presentation.ui.screen.detail.DetailViewModel
import com.fara.feature_home.presentation.ui.screen.detail.DetailViewModelImpl
import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.feature_home_domain.domain.usecase.numbers.GetNumberHistoryByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    private val getNumberHistoryByIdUseCase = Mockito.mock<GetNumberHistoryByIdUseCase>()

    private lateinit var viewModel: DetailViewModel

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = DetailViewModelImpl(
            getNumberHistoryByIdUseCase = getNumberHistoryByIdUseCase
        )
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getNumbersHistoryByIdUseCase should get a number`() {
        runTest {
            val expected = NumberHistory(number = 0, text = "test")
            Mockito.`when`(getNumberHistoryByIdUseCase.invoke(expected.id)).thenReturn(expected)

            viewModel.getNumberHistoryById(expected.id)

            testDispatcher.scheduler.advanceUntilIdle()
            val actual = viewModel.uiState.value.numberHistory
            Assertions.assertEquals(expected, actual)
        }
    }
}