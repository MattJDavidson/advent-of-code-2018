data class CheckSumComponent(val pair: Int, val triple: Int)

fun components(text: String): CheckSumComponent {
    val counts = text.groupingBy { it }.eachCount().values
    return CheckSumComponent(
            if (2 in counts) 1 else 0,
            if (3 in counts) 1 else 0)
}

fun checksum(lines: List<String>): Int {
    var pairs = 0
    var triples = 0
    for (line in lines) {
        val component = components(line)
        pairs += component.pair
        triples += component.triple
    }
    return pairs * triples
}

fun distance(x: String, y: String): Int {
    val count = x.zip(y).count { it.first != it.second }
    return count
}

fun commonCharInPrototypes(input: List<String>): String {
    for (line in input) {
        for (otherLine in input) {
            if (distance(line, otherLine) == 1) {
                var output = ""
                line.zip(otherLine) { a, b ->
                    output += (if (a == b) a else "")
                }
                return output
            }
        }
    }
    return ""
}
