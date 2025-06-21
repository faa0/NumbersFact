package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.network.repository.NumberRepository
import com.fara.feature_home_domain.domain.model.Number
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
class GetRandomNumberUseCaseImplTest {

    private val repository = mock(NumberRepository::class.java)

    private lateinit var useCase: GetRandomNumberUseCaseImpl

    @BeforeEach
    fun setUp() {
        useCase = GetRandomNumberUseCaseImpl(repository)
    }

    @Test
    fun `invoke should return success result from repository`() {
        runTest {
            val number = Number(0, "test")
            val expected = Result.success(number)
            `when`(repository.getRandomNumber()).thenReturn(expected)

            val actual = useCase.invoke()

            assertEquals(expected, actual)
            verify(repository).getRandomNumber()
        }
    }

    @Test
    fun `invoke should return failure when repository returns failure`() {
        runTest {
            val exception = RuntimeException("error")
            val expected = Result.failure<Number>(exception)
            `when`(repository.getRandomNumber()).thenReturn(expected)

            val actual = useCase.invoke()

            assertTrue(actual.isFailure)
            assertEquals(expected.exceptionOrNull()?.message, actual.exceptionOrNull()?.message)
            verify(repository).getRandomNumber()
        }
    }

    @Test
    fun `invoke should not make any extra repository calls`() {
        runTest {
            val number = Number(0, "test")
            val expected = Result.success(number)
            `when`(repository.getRandomNumber()).thenReturn(expected)

            useCase.invoke()

            verify(repository).getRandomNumber()
            verifyNoMoreInteractions(repository)
        }
    }
}
