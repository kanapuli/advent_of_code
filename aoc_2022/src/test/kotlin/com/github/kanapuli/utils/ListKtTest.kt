package com.github.kanapuli.utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ListKtTest {

    @Test
    fun sortedDescending() {
        val input = listOf<Int>(1, 2, 3, 4)
        val actualOutput = input.sortedDescending()
        val expectedOutput = listOf(4,3,2,1)
        assertEquals(expectedOutput, actualOutput )
    }
}