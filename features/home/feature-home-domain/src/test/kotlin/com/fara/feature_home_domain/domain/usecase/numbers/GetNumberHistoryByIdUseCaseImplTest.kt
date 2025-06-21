package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.feature_home_domain.data.local.repository.NumberHistoryRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`

@OptIn(ExperimentalCoroutinesApi::class)
class GetNumberHistoryByIdUseCaseImplTest {

    private val repository = mock(NumberHistoryRepository::class.java)

    private lateinit var useCase: GetNumberHistoryByIdUseCaseImpl

    @BeforeEach
    fun setUp() {
        useCase = GetNumberHistoryByIdUseCaseImpl(repository)
    }

    @Test
    fun `invoke should return correct number history from repository`() {
        runTest {
            val expected = NumberHistory(id = 1, number = 0, text = "test")
            `when`(repository.getNumberHistoryById(1)).thenReturn(expected)

            val actual = useCase.invoke(1)

            assertEquals(expected, actual)
            verify(repository).getNumberHistoryById(1)
        }
    }

    @Test
    fun `invoke should return incorrect result if repository returns wrong data`() {
        runTest {
            val wrongResult = NumberHistory(id = 0, number = 0, text = "test")
            val expected = NumberHistory(id = 1, number = 1, text = "test")

            `when`(repository.getNumberHistoryById(1)).thenReturn(wrongResult)

            val actual = useCase.invoke(1)

            assertNotEquals(expected, actual)
            verify(repository).getNumberHistoryById(1)
        }
    }

    @Test
    fun `invoke should not make any extra repository calls`() {
        runTest {
            val expected = NumberHistory(id = 1, number = 0, text = "test")
            `when`(repository.getNumberHistoryById(1)).thenReturn(expected)

            val actual = useCase.invoke(1)

            assertEquals(expected, actual)
            verify(repository).getNumberHistoryById(1)
            verifyNoMoreInteractions(repository)
        }
    }
}
