package submarine_movement

fun forwards(distance: UInt): (Position) -> Position = {
    Forwards(distance).moveFrom(it)
}

private class Forwards(distance: UInt): Movement {
    private val distance = distance

    override fun moveFrom(position: Position): Position {
        return position.copy(horizontal = position.horizontal + distance, depth = position.depth + position.aim * distance)
    }
}
