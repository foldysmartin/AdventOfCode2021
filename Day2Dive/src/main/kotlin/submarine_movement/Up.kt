package submarine_movement

fun up(distance: UInt): (Position) -> Position =  {
    Up(distance).moveFrom(it)
}

private class Up(distance: UInt): Movement {
    private val distance = distance

    override fun moveFrom(position: Position): Position {
        return position.copy(aim = decreaseToZero(position.aim))
    }

    private fun decreaseToZero(value: UInt): UInt {
        return if (distance > value) {
            0u;
        } else {
            value - distance
        }
    }
}
