import hydrothermalVents.Vent
import hydrothermalVents.VentMap
import java.awt.Point
import java.io.File

fun main() {
    val vents = File("src", "vents.txt").readLines()
        .map {
            val coordinates = it.split("->")
            val startingPoint = toPoint(coordinates.first())
            val endPoint = toPoint(coordinates.last())
            Vent(startingPoint, endPoint)
        }

    val dangerZones = VentMap(vents).dangerZoneCount()
    println("There are $dangerZones danger zones")
}

private fun toPoint(stringCoordinate: String): Point {
    val splitCoordinate = stringCoordinate.split(',').map { it.trim() }
    return Point(splitCoordinate.first().toInt(), splitCoordinate.last().toInt())
}