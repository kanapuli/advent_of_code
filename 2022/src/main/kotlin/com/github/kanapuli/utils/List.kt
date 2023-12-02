package com.github.kanapuli.utils

fun <T : Comparable<T>> List<T>.sortedDescending(): List<T> {
    return mergeSort(this)
}

/**
 * intersect returns the list of unique common elements between two lists
 * TODO: Improve the algorithm using binary operation
 */
fun <T: Comparable<T>> List<T>.intersect(secondList: List<T>): List<T> {
    val intersectedList = mutableListOf<T>()
    val hashOfIntersectedItems = mutableMapOf<T, Any?>()
    this.forEach { a ->
        secondList.forEach { b ->
            if (a == b && !hashOfIntersectedItems.containsKey(a)) {
                intersectedList.add(a)
                hashOfIntersectedItems[a] = null
            }
        }
    }
    return intersectedList
}

/**
 * mergeSort sorts an array in descending order using the mergesort algorithm
 */
private fun <T : Comparable<T>> mergeSort(list: List<T>): List<T> {
    // base case
    if (list.size <= 1) return list

    // Find the midpoint
    val middle = list.size / 2

    // Again split left and again split right
    val left = list.subList(0, middle)
    val right = list.subList(middle, list.size)

    // recursively call mergesort
    return merge(mergeSort(left), mergeSort(right))
}

private fun <T : Comparable<T>> merge(left: List<T>, right: List<T>): List<T> {
    val list = mutableListOf<T>()
    var indexLeft = 0
    var indexRight = 0
    while (indexLeft < left.count() && indexRight < right.count()) {
        if (left[indexLeft] >= right[indexRight]) {
            list.add(left[indexLeft])
            indexLeft++
        } else {
            list.add(right[indexRight])
            indexRight++
        }
    }

    while (indexLeft < left.count()) {
        list.add(left[indexLeft])
        indexLeft++
    }
    while (indexRight < right.count()) {
        list.add(right[indexRight])
        indexRight++
    }

    return list
}
