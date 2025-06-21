package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.local.repository.NumberHistoryRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`

@OptIn(ExperimentalCoroutinesApi::class)
class IsNumberHistoryExistUseCaseImplTest {

    private val repository = mock(NumberHistoryRepository::class.java)
    private lateinit var useCase: IsNumberHistoryExistUseCaseImpl

    @BeforeEach
    fun setUp() {
        useCase = IsNumberHistoryExistUseCaseImpl(repository)
    }

    @Test
    fun `invoke should return true when repository confirms existence`() = runTest {
        `when`(repository.isNumberHistoryExist("test")).thenReturn(true)

        val result = useCase.invoke("test")

        assertTrue(result)
        verify(repository).isNumberHistoryExist("test")
    }

    @Test
    fun `invoke should return false when repository confirms non-existence`() = runTest {
        `when`(repository.isNumberHistoryExist("test")).thenReturn(false)

        val result = useCase.invoke("test")

        assertFalse(result)
        verify(repository).isNumberHistoryExist("test")
    }

    @Test
    fun `invoke should not make any extra repository calls`() = runTest {
        `when`(repository.isNumberHistoryExist("test")).thenReturn(true)

        useCase.invoke("test")

        verify(repository).isNumberHistoryExist("test")
        verifyNoMoreInteractions(repository)
    }
}
