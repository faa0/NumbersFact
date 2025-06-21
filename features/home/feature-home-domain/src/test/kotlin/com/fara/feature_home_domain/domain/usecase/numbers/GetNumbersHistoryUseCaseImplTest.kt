package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.feature_home_domain.data.local.repository.NumberHistoryRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`

@OptIn(ExperimentalCoroutinesApi::class)
class GetNumbersHistoryUseCaseImplTest {

    private val repository = mock(NumberHistoryRepository::class.java)
    private lateinit var useCase: GetNumbersHistoryUseCaseImpl

    @BeforeEach
    fun setUp() {
        useCase = GetNumbersHistoryUseCaseImpl(repository)
    }

    @Test
    fun `invoke should return flow from repository`() {
        runTest {
            val historyList = listOf(
                NumberHistory(id = 1, number = 0, text = "Test"),
                NumberHistory(id = 2, number = 1, text = "Test")
            )

            `when`(repository.getNumbersHistoryFlow()).thenReturn(flowOf(historyList))

            val result = useCase.invoke().first()

            assertEquals(historyList, result)
            verify(repository).getNumbersHistoryFlow()
        }
    }

    @Test
    fun `invoke should emit empty list when repository emits empty list`() {
        runTest {
            `when`(repository.getNumbersHistoryFlow()).thenReturn(flowOf(emptyList()))

            val result = useCase.invoke().first()

            assertTrue(result.isEmpty())
            verify(repository).getNumbersHistoryFlow()
        }
    }

    @Test
    fun `invoke should not make extra repository calls`() {
        runTest {
            val expected = listOf(NumberHistory(id = 1, number = 0, text = "test"))
            `when`(repository.getNumbersHistoryFlow()).thenReturn(flowOf(expected))

            useCase.invoke().first()

            verify(repository).getNumbersHistoryFlow()
            verifyNoMoreInteractions(repository)
        }
    }
}
