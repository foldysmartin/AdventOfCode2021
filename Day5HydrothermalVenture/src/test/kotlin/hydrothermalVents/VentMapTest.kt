package hydrothermalVents

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.awt.Point

internal class VentMapTest {

    @Test
    fun noNoneCrossingVentsAreOfNoDanger() {
        val vents = arrayListOf(
            Vent(Point(0, 9), Point(5,9)),
            Vent(Point(9, 4), Point(3,4))
        )
        assertEquals(0u, VentMap(vents).dangerZoneCount())
    }

    @Test
    fun crossingVentIsADanger() {
        val vents = arrayListOf(
            Vent(Point(2, 9), Point(5,9)),
            Vent(Point(0, 9), Point(4,9))
        )
        assertEquals(3u, VentMap(vents).dangerZoneCount())
    }

    @Test
    fun crossingDiagonalVentsAreADanger() {
        val vents = arrayListOf(
            Vent(Point(2, 2), Point(4,4)),
            Vent(Point(2, 4), Point(4,2))
        )
        assertEquals(1u, VentMap(vents).dangerZoneCount())
    }

    @Test
    fun dangerousVentsWithEndLessThanTheStartAreDetected() {
        val vents = arrayListOf(
            Vent(Point(3, 5), Point(3,1)),
            Vent(Point(5, 3), Point(1,3))
        )
        assertEquals(1u, VentMap(vents).dangerZoneCount())
    }

    @Test
    fun dangerZoneCount() {
        val vents = arrayListOf(
            Vent(Point(0, 9), Point(5,9)),
            Vent(Point(8, 0), Point(0,8)),
            Vent(Point(9, 4), Point(3,4)),
            Vent(Point(2, 2), Point(2,1)),
            Vent(Point(7, 0), Point(7,4)),
            Vent(Point(6, 4), Point(2,0)),
            Vent(Point(0, 9), Point(2,9)),
            Vent(Point(3, 4), Point(1,4)),
            Vent(Point(0, 0), Point(8,8)),
            Vent(Point(5, 5), Point(8,2)),
        )

        assertEquals(12u, VentMap(vents).dangerZoneCount())
    }
}