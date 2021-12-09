package submarine_movement

fun down(distance: UInt): (Position) -> Position =  {
    Downwards(distance).moveFrom(it)
}

internal class Downwards(distance: UInt): Movement {
    private val distance = distance

    override fun moveFrom(position: Position): Position {
        return position.copy(aim = position.aim + distance)
    }
}