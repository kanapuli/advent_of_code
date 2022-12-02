import java.io.File

fun main(){
    val problem01Input = "Day01_1.txt"
    val maxCalorie = problem01(problem01Input)
    println(maxCalorie)
}

fun problem01(filePath: String): Int {
    var maxCalorie = 0
    try {
        var caloriesOfAnElf = 0
        readCalories(filePath)
            .forEachLine { calorie ->
                if (calorie.isNotEmpty()) {
                    caloriesOfAnElf += calorie.toInt()
                } else {
                    if (maxCalorie < caloriesOfAnElf) {
                        maxCalorie = caloriesOfAnElf
                    }
                    //reset caloriesOfAnElf on every Blank line
                    caloriesOfAnElf = 0
                }
            }
        return maxCalorie
    } catch (e: NullPointerException) {
        throw Exception("The file path $filePath could not be found")
    }
}

fun readCalories(filePath: String): File = File(ClassLoader.getSystemResource(filePath).file)
