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
