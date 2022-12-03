package com.github.kanapuli

import com.github.kanapuli.utils.readFile
import java.io.File

/**
 * GameInputs is the possible inputs in rock,scissors and paper game
 * and each member is defined with its score
 */
enum class GameInputs(val score: Int, val winHand: String, val lossHand: String) {
    ROCK(1, "Y", "Z"),
    PAPER(2, "Z", "X"),
    SCISSORS(3, "X", "Y"),
}

/**
 * RoundResults is the combination of possible results in a game and its score
 */
enum class RoundResults(val score: Int, val strategy: String) {
    WIN(6, "Z"),
    LOSS(0, "X"),
    DRAW(3, "Y")
}

fun main() {
    val hand = mapOf<String, GameInputs>(
        "A" to GameInputs.ROCK,
        "X" to GameInputs.ROCK,
        "B" to GameInputs.PAPER,
        "Y" to GameInputs.PAPER,
        "C" to GameInputs.SCISSORS,
        "Z" to GameInputs.SCISSORS,
    )

    readFile("Day02.txt")
        .also {
            val score = problem0201(it, hand)
            println(score) // 12458
        }
        .also {
            val score = problem0202(it, hand)
            println(score) // 12683
        }
}

/**
 * problem0201 calculates the score of a rock,paper,scissors game between two players
 */
fun problem0201(file: File, hand: Map<String, GameInputs>): Int {
    return file.readLines().map {
        val (player1, player2) = it.split(" ")
        when {
            hand[player1] == hand[player2] -> {
                hand[player2]!!.score + RoundResults.DRAW.score
            }

            hand[player1]!!.winHand == player2 -> {
                hand[player2]!!.score + RoundResults.WIN.score
            }

            else -> {
                hand[player2]!!.score + RoundResults.LOSS.score
            }

        }
    }.reduce { acc, x ->
        acc + x
    }
}

/**
 * problem0202 chooses the player 2 hand based on a strategy guide and calculates the score
 * The strategy guide is defined in the RoundResults enum
 */
fun problem0202(
    file: File,
    hand: Map<String, GameInputs>
): Int {
    return file.readLines().map {
        val (player1, player2) = it.split(" ")
        when (player2) {
            RoundResults.WIN.strategy -> {
                val strategyHand = hand[player1]!!.winHand
                hand[strategyHand]!!.score + RoundResults.WIN.score
            }

            RoundResults.LOSS.strategy -> {
                val strategyHand = hand[player1]!!.lossHand
                hand[strategyHand]!!.score + RoundResults.LOSS.score
            }

            RoundResults.DRAW.strategy -> {
                hand[player1]!!.score + RoundResults.DRAW.score
            }

            else -> 0
        }
    }.reduce { acc, i ->
        acc + i
    }
}