import submarine_movement.down
import submarine_movement.forwards
import submarine_movement.moveSubmarine
import submarine_movement.up
import java.io.File
import java.lang.Exception

fun main() {
    val movements =  File("src", "movements.txt").readLines().map{
        val a = it.split(" ")
        when (a[0]) {
            "forward" -> forwards(a[1].toUInt())
            "down" -> down(a[1].toUInt())
            "up" -> up(a[1].toUInt())
            else -> throw Exception("Unexpected Input $a[0]")
        }
    }

    val position = moveSubmarine(movements)
    print("Sub travel ${position.horizontal} at a depth of ${position.depth}, when multiplied equals ${position.horizontal * position.depth}")
}

