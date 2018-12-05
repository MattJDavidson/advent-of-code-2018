data class Claim(val id: Int, val left: Int, val top: Int, val width: Int, val height: Int) {
    fun area(): List<Pair<Int, Int>> =
            (0 + left until width + left).flatMap { width ->
                (0 + top until height + top).map { height ->
                    Pair(width, height)
                }
            }

    companion object {
        private val pattern = """^#(\d+) @ (\d+),(\d+): (\d+)x(\d+)$""".toRegex()
        fun fromLine(line: String): Claim {
            return pattern.find(line)?.let {
                val (id, left, top, width, height) = it.destructured
                Claim(id.toInt(), left.toInt(), top.toInt(), width.toInt(), height.toInt())
            }!!
        }
    }
}

fun listClaims(input: List<String>):List<Claim>{
    return input.map{Claim.fromLine(it)}
}

fun processCollisions(claims: List<Claim>): Int =
        claims.flatMap { it.area() }
                .groupingBy { it }
                .eachCount()
                .count { it.value > 1 }

