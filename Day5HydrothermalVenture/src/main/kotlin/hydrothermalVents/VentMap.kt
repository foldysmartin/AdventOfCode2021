package hydrothermalVents

import java.awt.Point
import kotlin.math.abs

class VentMap(private val vents: Collection<Vent>){

    fun dangerZoneCount(): UInt {
        return vents.flatMap {
            val coordinatesCovered = it.start .. it.end
            coordinatesCovered
        }.groupBy { it }.count{it.value.size > 1}.toUInt()
    }
}

//Assumes x and y values increase at the same rate or only one increases
private operator fun Point.rangeTo(end: Point): List<Point> {
    return if (this.x == end.x) {
        yValues(end).map{Point(this.x, it)}
    }
    else if (this.y == end.y) {
        xValues(end).map{Point(it, this.y)}
    }
    else if (abs(this.y - end.y) == abs(this.x - end.x)) {
        xValues(end).zip(yValues(end)).map { Point(it.first, it.second) }
    }
    else {
        throw NotImplementedError("Range not implemented for Points $this and $end")
    }
}

private fun Point.yValues(end: Point) = if (this.y < end.y) {
    this.y..end.y
} else {
    this.y downTo end.y
}

private fun Point.xValues(end: Point) = if (this.x < end.x) {
    this.x..end.x
} else {
    this.x downTo end.x
}
