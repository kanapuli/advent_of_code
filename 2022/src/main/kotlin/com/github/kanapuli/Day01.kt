import java.io.File
import com.github.kanapuli.utils.readFile
import com.github.kanapuli.utils.sortedDescending

fun main() {
    readFile("Day01_1.txt")
        .also {
            val maxCalorie = problem01(it)
            println(maxCalorie) // 68802
        }
        .also {
            val maxCaloriesOfThreeElves = problem02(it, 3)
            println(maxCaloriesOfThreeElves) // 205370
        }
}

/**
 * problem01 is to find the max calorie that an elf is carrying
 * @param input - list of calorie inputs
 */
fun problem01(input: File): Int = input.let {
    caloriesOfElvesSortedDescending(it).first()
}


/**
 * problem02 is to find the total of top 3 maximum calories carried by the elves
 * @param input - list of calorie inputs
 * @param numberOfElves - Top 'n' to be considered for calorie calculation
 */
fun problem02(input: File, numberOfElves: Int): Int = input.let {
    caloriesOfElvesSortedDescending(it).take(numberOfElves).reduce { acc, i ->
        acc + i
    }
}

/**
 * caloriesOfElvesSortedDescending returns a list of calories carried by each
 * elf. The final list is sorted in descending order
 */
fun caloriesOfElvesSortedDescending(file: File): List<Int> {
    var caloriesCarriedByElves = mutableListOf<Int>()
    try {
        var caloriesOfAnElf = 0
        file
            .forEachLine { calorie ->
                if (calorie.isNotEmpty()) {
                    caloriesOfAnElf += calorie.toInt()
                } else {
                    caloriesCarriedByElves.add(caloriesOfAnElf)
                    caloriesOfAnElf = 0
                }
            }
        return caloriesCarriedByElves.sortedDescending()
    } catch (e: NullPointerException) {
        //TODO: Avoid side effects from this function
        throw Exception("The file path ${file.path} could not be found")
    }
}