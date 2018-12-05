import org.junit.jupiter.api.Test
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.greaterThan

class Day03Should {

    val inputPath = "/Users/Matt/workspace/advent-of-code-2018/src/test/resources/day03.txt"
    val input = readFileAsStrings(inputPath)

    @Test
    fun `parse a line correctly`() {
        assert.that(Claim.fromLine("#123 @ 3,2: 5x4"), equalTo(Claim(123, 3, 2, 5, 4)))
        assert.that(Claim.fromLine("#1 @ 1,3: 4x4"), equalTo(Claim(1, 1, 3, 4, 4)))
        assert.that(Claim.fromLine("#2 @ 3,1: 4x4"), equalTo(Claim(2, 3, 1, 4, 4)))
        assert.that(Claim.fromLine("#3 @ 5,5: 2x2"), equalTo(Claim(3, 5, 5, 2, 2)))
    }

    @Test
    fun `can generate claims from input`(){
        assert.that(
                    listClaims(
                            listOf(
                                    "#1 @ 1,3: 4x4",
                                    "#2 @ 3,1: 4x4",
                                    "#3 @ 5,5: 2x2")),
                equalTo(
                        listOf(
                                Claim(1, 1, 3, 4, 4),
                                Claim(2, 3, 1, 4, 4),
                                Claim(3, 5, 5, 2, 2)
                                ))) }

    @Test
    fun `separate claims do not cause collision`(){
        assert.that(
                processCollisions(
                    listOf(
                            Claim(1, 1, 1, 1, 1),
                            Claim(2, 10, 10, 1, 1)
                    )),
                equalTo(0))
    }

    @Test
    fun `intersecting claims do cause collision`() {
        assert.that(
                processCollisions(
                        listOf(
                                Claim(1, 1, 1, 10, 10),
                                Claim(2, 1, 1, 10, 10)
                        )),
                greaterThan(1))
    }

    @Test
    fun `solve part 1`(){
        assert.that(processCollisions(listClaims(input)), equalTo(111485))
    }
}

