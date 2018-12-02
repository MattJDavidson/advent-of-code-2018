import org.junit.jupiter.api.Test
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo

class Day02Should {

    val inputPath = "/Users/Matt/workspace/advent-of-code-2018/src/test/resources/day02.txt"
    val input = readFileAsStrings(inputPath)

    @Test
    fun `return 0 for checksum`() {
        assert.that(components("abcdef"), equalTo(CheckSumComponent(0, 0)))
    }

    @Test
    fun `return 1 for two repeated characters`() {
        assert.that(components("abcdee"), equalTo(CheckSumComponent(1, 0)))
    }

    @Test
    fun `return 1 for three repeated characters`() {
        assert.that(components("abcccd"), equalTo(CheckSumComponent(0, 1)))
    }

    @Test
    fun `return 2 for two different repeated component`() {
        assert.that(components("bababc"), equalTo(CheckSumComponent(1, 1)))
    }

    @Test
    fun `return 1 for multiple pairs`() {
        assert.that(components("aabcdd"), equalTo(CheckSumComponent(1, 0)))
    }

    @Test
    fun `return 1 for multiple triples`() {
        assert.that(components("ababab"), equalTo(CheckSumComponent(0, 1)))
    }

    @Test
    fun `return checksum for single line without pair and triple`() {
        assert.that(checksum(listOf("abcdef")), equalTo(0))
    }

    @Test
    fun `return checksum for single line with only one pair or triple`() {
        assert.that(checksum(listOf("abcdee")), equalTo(0))
        assert.that(checksum(listOf("abcccd")), equalTo(0))
    }

    @Test
    fun `return checksum for single line with pair and triple`() {
        assert.that(checksum(listOf("bababc")), equalTo(1))
    }

    @Test
    fun `return checksum for multiple line with pair and triple`() {
        assert.that(checksum(listOf("abcdee", "bababc")), equalTo(2))
        assert.that(checksum(listOf("abcdef",
                "bababc",
                "abbcde",
                "abcccd",
                "aabcdd",
                "abcdee",
                "ababab"
        )), equalTo(12))
    }

    @Test
    fun `solve part 1`() {
        assert.that(checksum(input), equalTo(7533))
    }

    @Test
    fun `calculate distance of two strings`() {
        assert.that(distance("abcde", "abcde"), equalTo(0))
        assert.that(distance("fghij", "fguij"), equalTo(1))
        assert.that(distance("abcde", "axcye"), equalTo(2))
    }

    @Test
    fun `solve part 2`() {
        assert.that(commonCharInPrototypes(input), equalTo("mphcuasvrnjzzkbgdtqeoylva"))
    }
}
