package lanternfish

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LanternfishTest {

    @Test
    fun daysRemainingIsReducedBy1AfterGestating() {
        val lanternfish = Lanternfish(2u).gestate()
        assertEquals(1, lanternfish.size)
        assertEquals(Lanternfish(1u), lanternfish.first())
    }

    @Test
    fun newLanternfishIsSpawnedWhenGestationOccursAndDaysRemainingEquals0() {
        val lanternfish = Lanternfish(0u).gestate()
        assertEquals(2, lanternfish.size)
        assertEquals(Lanternfish(8u), lanternfish.last())
    }

    @Test
    fun dayRemainingResetsTo6WhenANewFishIsSpawned() {
        val lanternfish = Lanternfish(0u).gestate()
        assertEquals(2, lanternfish.size)
        assertEquals(Lanternfish(6u), lanternfish.first())
    }
}