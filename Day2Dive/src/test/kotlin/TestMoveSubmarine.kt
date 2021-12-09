import submarine_movement.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class TestMoveSubmarine {
    @Test
    fun emptyArrayReturnsOrigin() {
        val expected = Position(0u, 0u, 0u)
        assertEquals(expected, moveSubmarine(listOf()))
    }

    @Test
    fun subMovedForwards() {
        var expected = Position(5u, 0u, 0u )
        assertEquals(expected, moveSubmarine(listOf(forwards(5u))))
    }

    @Test
    fun subMovedDown() {
        var expected = Position(0u, 0u, 5u)
        assertEquals(expected, moveSubmarine(listOf(down(5u))))
    }

    @Test
    fun subMovedUp() {
        var expected = Position(0u, 0u, 5u)
        assertEquals(expected, moveSubmarine(listOf(down(10u), up(5u))))
    }

    @Test
    fun subDepthIncreasesWhenMovingForwardsAtDepth() {
        var expected = Position(8u, 40u, 5u)
        assertEquals(expected, moveSubmarine(listOf(down(5u), forwards(8u))))
    }

    @Test
    fun subCannotFly() {
        var expected = Position(0u, 0u, 0u)
        assertEquals(expected, moveSubmarine(listOf(up(5u))))
    }

    @Test
    fun subMultipleMovements() {
        var expected = Position(15u, 60u, 10u)
        assertEquals(expected, moveSubmarine(listOf(forwards(5u), down(5u), forwards(8u), up(3u), down(8u), forwards(2u))))
    }
}