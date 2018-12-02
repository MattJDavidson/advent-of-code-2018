import java.io.File

const val day01_input = "/Users/Matt/workspace/advent-of-code-2018/src/main/resources/day01.txt"

fun readFileAsStrings(filePath: String): List<String> = File(filePath).readLines()

fun part1(filePath: String): Int =
        readFileAsStrings(filePath)
                .map(String::toInt)
                .sum()

fun hitCollision(inputs: List<Int>,
                 pastTotals: MutableList<Int> = mutableListOf(0),
                 total: Int = 0): Int {
    var localTotal = total
    for (input in inputs) {
        localTotal += input
        if (localTotal in pastTotals)
            return localTotal
        pastTotals += localTotal
    }
    return hitCollision(inputs, pastTotals, localTotal)
}

fun part2(filePath: String): Int =
        hitCollision((readFileAsStrings(filePath).map(String::toInt)))

