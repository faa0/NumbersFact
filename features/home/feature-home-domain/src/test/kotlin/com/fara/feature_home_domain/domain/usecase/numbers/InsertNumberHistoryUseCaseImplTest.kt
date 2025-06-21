package com.fara.feature_home_domain.domain.usecase.numbers

import com.fara.feature_home_domain.data.local.entity.NumberHistory
import com.fara.feature_home_domain.data.local.mapper.domain_to_local.NumberToNumberHistoryMapper
import com.fara.feature_home_domain.data.local.repository.NumberHistoryRepository
import com.fara.feature_home_domain.domain.model.Number
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.Mockito.`when`

@OptIn(ExperimentalCoroutinesApi::class)
class InsertNumberHistoryUseCaseImplTest {

    private val repository = mock(NumberHistoryRepository::class.java)
    private val mapper = mock(NumberToNumberHistoryMapper::class.java)
    private lateinit var useCase: InsertNumberHistoryUseCaseImpl

    @BeforeEach
    fun setUp() {
        useCase = InsertNumberHistoryUseCaseImpl(repository, mapper)
    }

    @Test
    fun `invoke should map number and insert history to repository`() = runTest {
        val number = Number(0, "test")
        val mapped = NumberHistory(id = 1, number = 0, text = "test")

        `when`(mapper.invoke(number)).thenReturn(mapped)

        useCase.invoke(number)

        verify(mapper).invoke(number)
        verify(repository).insertNumberHistory(mapped)
        verifyNoMoreInteractions(mapper, repository)
    }
}
