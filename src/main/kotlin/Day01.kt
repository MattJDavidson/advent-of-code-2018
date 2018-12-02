fun part1(inputs: List<String>): Int = inputs.map(String::toInt).sum()

fun hitCollision(inputs: List<Int>,
                 pastTotals: MutableList<Int> = mutableListOf(0),
                 total: Int = 0): Int {
    var localTotal = total
    inputs.forEach { input ->
        localTotal += input
        if (localTotal in pastTotals)
            return localTotal
        pastTotals += localTotal
    }
    return hitCollision(inputs, pastTotals, localTotal)
}

fun part2(inputs: List<String>): Int =
        hitCollision(inputs.map(String::toInt))

