package com.fara.feature_home_domain.domain.usecase.numbers

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NumberMatchesFormatUseCaseImplTest {

    private lateinit var useCase: NumberMatchesFormatUseCaseImpl

    @BeforeEach
    fun setUp() {
        useCase = NumberMatchesFormatUseCaseImpl()
    }

    @Test
    fun `invoke should return true for lower bound`() {
        assertTrue(useCase.invoke(0))
    }

    @Test
    fun `invoke should return true for upper bound`() {
        assertTrue(useCase.invoke(9999))
    }

    @Test
    fun `invoke should return true for middle value`() {
        assertTrue(useCase.invoke(5000))
    }

    @Test
    fun `invoke should return false for negative number`() {
        assertFalse(useCase.invoke(-1))
    }

    @Test
    fun `invoke should return false for number above range`() {
        assertFalse(useCase.invoke(10000))
    }
}
