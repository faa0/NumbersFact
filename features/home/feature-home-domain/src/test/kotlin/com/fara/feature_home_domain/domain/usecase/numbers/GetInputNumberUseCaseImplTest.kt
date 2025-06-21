package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.network.repository.NumberRepository
import com.fara.feature_home_domain.domain.model.Number
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`

@OptIn(ExperimentalCoroutinesApi::class)
class GetInputNumberUseCaseImplTest {

    private val repository = mock(NumberRepository::class.java)

    private lateinit var useCase: GetInputNumberUseCaseImpl

    @BeforeEach
    fun setUp() {
        useCase = GetInputNumberUseCaseImpl(repository)
    }

    @Test
    fun `invoke should return success when repository returns result`() {
        runTest {
            val expected = Result.success(Number(0, "test"))
            `when`(repository.getInputNumber(0)).thenReturn(expected)

            val actual = useCase.invoke(0)

            assertEquals(expected, actual)
            verify(repository).getInputNumber(0)
        }
    }

    @Test
    fun `invoke should return failure when repository returns failure`() {
        runTest {
            val exception = RuntimeException("Repository failure")
            val expected = Result.failure<Number>(exception)
            `when`(repository.getInputNumber(0)).thenReturn(expected)

            val actual = useCase.invoke(0)

            assertEquals(expected.exceptionOrNull()?.message, actual.exceptionOrNull()?.message)
            verify(repository).getInputNumber(0)
        }
    }

    @Test
    fun `invoke should not perform extra repository calls`() {
        runTest {
            val expected = Result.success(Number(0, "test"))
            `when`(repository.getInputNumber(0)).thenReturn(expected)

            val actual = useCase.invoke(0)

            assertEquals(expected, actual)
            verify(repository).getInputNumber(0)
            verifyNoMoreInteractions(repository)
        }
    }
}
