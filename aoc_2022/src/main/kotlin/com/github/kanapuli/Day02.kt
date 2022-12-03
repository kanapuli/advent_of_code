package com.github.kanapuli

import com.github.kanapuli.utils.readFile
import java.io.File

/**
 * GameInputs is the possible inputs in rock,scissors and paper game
 * and each member is defined with its score
 */
enum class GameInputs(val score: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3),
}

/**
 * ResultsScore is the combination of possible results in a game and its score
 */
enum class ResultsScore(val score: Int) {
    WIN(6),
    LOSS(0),
    DRAW(3)
}

fun main() {
    val winningHand = mapOf<String, String>(
        "A" to "Y",
        "B" to "Z",
        "C" to "X"
    )
    val hand = mapOf<String, GameInputs>(
        "A" to GameInputs.ROCK,
        "X" to GameInputs.ROCK,
        "B" to GameInputs.PAPER,
        "Y" to GameInputs.PAPER,
        "C" to GameInputs.SCISSORS,
        "Z" to GameInputs.SCISSORS,
    )

    readFile("Day02.txt").let {
        val score = problem0201(it, winningHand, hand)
        println(score) // 12458
    }
}

/**
 * problem0201 calculates the score of a rock,paper,scissors game between two players
 */
fun problem0201(file: File, winningHand: Map<String, String>, hand: Map<String, GameInputs>): Int {
    return file.readLines().map {
        val (player1, player2) = it.split(" ")
        when {
            hand[player1] == hand[player2] -> {
                hand[player2]!!.score + ResultsScore.DRAW.score
            }

            winningHand[player1] == player2 -> {
                hand[player2]!!.score + ResultsScore.WIN.score
            }

            else -> {
                hand[player2]!!.score + ResultsScore.LOSS.score
            }

        }
    }.reduce { acc, x ->
        acc + x
    }
}
