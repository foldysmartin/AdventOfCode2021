package lanternfish

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class SchoolTest {

    @Test
    fun numberOfFishIncreaseWithGestation() {
        val startingSchool = School(
            arrayListOf(
                Lanternfish(0u),
            )
        )

        assertEquals(2uL, startingSchool.gestate().size)
    }

    @Test
    fun numberOfFishIncreasesOverMultipleDays() {
        val startingSchool = School(
            arrayListOf(
                Lanternfish(1u),
            )
        )

        assertEquals(2uL, startingSchool.gestate(2u).size)
    }

    @Test
    fun testWithLotsOfFish() {
        val startingSchool = School(
            arrayListOf(
                Lanternfish(3u),
                Lanternfish(4u),
                Lanternfish(3u),
                Lanternfish(1u),
                Lanternfish(2u),
            )
        )

        assertEquals(26uL, startingSchool.gestate(18u).size)
    }

    @Test
    fun testWithLotsOfFishAfter80Days() {
        val startingSchool = School(
            arrayListOf(
                Lanternfish(3u),
                Lanternfish(4u),
                Lanternfish(3u),
                Lanternfish(1u),
                Lanternfish(2u),
            )
        )

        assertEquals(5934uL, startingSchool.gestate(80u).size)
    }

    @Test
    fun testWithLotsOfFishAfter256Days() {
        val startingSchool = School(
            arrayListOf(
                Lanternfish(3u),
                Lanternfish(4u),
                Lanternfish(3u),
                Lanternfish(1u),
                Lanternfish(2u),
            )
        )

        assertEquals(26984457539uL, startingSchool.gestate(256u).size)
    }

}