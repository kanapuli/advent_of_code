package com.github.kanapuli

import com.github.kanapuli.utils.intersect
import com.github.kanapuli.utils.readFile
import com.github.kanapuli.utils.sortedDescending

import java.io.File

// THE aoc problem states that the lowercase letters from a-z must be represented
// from numbers 1-26. Instead of defining a dictionary to maintain this relation,
// it can be derived from the UTF-16 code. The UTF-16 code for lowercase 'a' starts
// from 97. Hence, subtract all lower case code encounters with 96
const val UTF16_DISCARD_NUMBER_LOWERCASE = 96

// The UTF-16 code for an upper case 'A' starts at 65. The aoc definition states that
// letters from A-Z must be represented by 27-52. Hence, subtract all upper case
// encounters with 38
const val UTF16_DISCARD_NUMBER_UPPERCASE = 38

fun main() {
    readFile("Day03.txt")
        .also {
            val sum = findSumOfPriorities(it)
            println(sum)
        }

}

/**
 * @see https://adventofcode.com/2022/day/3#part1
 */
fun findSumOfPriorities(file: File): Int {
    return file.readLines().map { line ->
        val midpoint = line.length / 2
        val compartment1 = line.subSequence(0, midpoint).toList().sortedDescending()
        val compartment2 = line.subSequence(midpoint, line.length).toList().sortedDescending()
        val commonItems = compartment1.intersect(compartment2)
        commonItems.map { item ->
            when {
                item.code in 65..96 -> item.code - UTF16_DISCARD_NUMBER_UPPERCASE
                item.code >= 97 -> item.code - UTF16_DISCARD_NUMBER_LOWERCASE
                else -> 0
            }
        }.reduce { acc, i ->
            acc + i
        }
    }.reduce { prioritySum, i ->
        prioritySum + i
    }
}