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
    @Test
    fun intersect() {
        val listA = listOf<Int>(1, 2, 3)
        val listB = listOf<Int>(1, 4, 5, 1)
        val expectedOutput = listOf<Int>(1)
        val actualOutput = listA.intersect(listB)
        assertEquals(expectedOutput, actualOutput)
    }
}