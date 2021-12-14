package bingo

data class Row constructor(
    internal val numbers: List<UInt>
) {
    constructor(vararg numbers: UInt): this(numbers.toList()) {
        assert(numbers.size == 5)
    }

    internal fun isComplete(calledNumbers: Collection<UInt>): Boolean {
        return numbers.all { calledNumbers.contains(it) }
    }
}