import com.natpryce.hamkrest.anything
import org.junit.jupiter.api.Test
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo

class Day01Should{

    @Test
    fun `solve part 1`(){
        assert.that(part1(day01_input), equalTo(430))
    }

    @Test
    fun `find non-repeating collision`(){
        assert.that(hitCollision(listOf(1,-1)), equalTo(0))
    }

    @Test
    fun `find collision when repetition of input needed`(){
        assert.that(hitCollision(listOf(3, 3, 4, -2, -4)), equalTo(10))
    }

    @Test
    fun `solve part 2`(){
        assert.that(part2(day01_input), equalTo(462))
    }

}