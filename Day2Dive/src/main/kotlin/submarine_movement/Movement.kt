package submarine_movement

interface Movement {
    fun moveFrom(position: Position): Position
}