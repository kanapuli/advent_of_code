package com.github.kanapuli

import com.github.kanapuli.utils.readFile
import java.io.File

fun main() {
    readFile("Day04.txt")
        .also {
            val containedRanges = findNumberOfContainedRanges(it)
            println(containedRanges) // 444
        }
        .also {
            val overlaps = findNumberOfOverlaps(it)
            println(overlaps)
        }

}

data class Range(val start: Int, val end: Int)

fun min(a: Int, b: Int): Int = if (a < b) a else b
fun max(a: Int, b: Int): Int = if (a > b) a else b

fun rangeLen(r: Range): Int = r.end - r.start

fun rangeOverlap(a: Range, b: Range): Range {
    return Range(max(a.start, b.start), min(a.end, b.end))
}

fun getRangesFromLine(line: String): Pair<Range, Range> {
    val (firstSection, secondSection) = line.split(",")
    val (firstSectionStart, firstSectionEnd) = firstSection.split("-").map { str ->
        str.toInt()
    }
    val (secondSectionStart, secondSectionEnd) = secondSection.split("-").map { str ->
        str.toInt()
    }
    val firstRange = Range(firstSectionStart, firstSectionEnd)
    val secondRange = Range(secondSectionStart, secondSectionEnd)
    return Pair(firstRange, secondRange)
}

fun findNumberOfContainedRanges(file: File): Int {
    return file.readLines().map { line ->
        val (firstRange, secondRange) = getRangesFromLine(line)
        val overlap = rangeOverlap(
            firstRange,
            secondRange
        )
        if (rangeLen(overlap) == rangeLen(firstRange) || rangeLen(overlap) == rangeLen(secondRange)) {
            1
        } else {
            0
        }
    }.reduce { acc, i ->
        acc + i
    }
}

fun findNumberOfOverlaps(file: File): Int {
    return file.readLines().map { line ->
        val (firstRange, secondRange) = getRangesFromLine(line)
        val overlap = rangeOverlap(
            firstRange,
            secondRange
        )
        if (rangeLen(overlap) >= 0) {
            1
        } else {
            0
        }

    }.reduce { acc, i ->
        acc + i
    }
}