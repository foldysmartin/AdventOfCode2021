package submarine_movement

fun moveSubmarine(movements: List<(Position) -> Position>): Position {
    val origin = Position(0u, 0u, 0u)
    return movements.fold(origin) { position, movement -> movement(position) }
}

