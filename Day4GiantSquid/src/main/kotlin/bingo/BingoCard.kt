package bingo

data class BingoCard private constructor(
    private val rows: List<Row>,
    private val calledNumbers: List<UInt> = listOf()
) {
    constructor(vararg rows: Row) : this(rows.toList()) {
        assert(rows.size == 5)
    }

    private val columns get() = (0 until 5).map { index -> Row(rows.map { it.numbers[index] }) }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val otherBingoBoard = other as BingoCard
        return rows == otherBingoBoard.rows
    }

    fun hasWon(): Boolean {
        return rows.any{it.isComplete(calledNumbers)} || columns.any{it.isComplete(calledNumbers)}
    }

    fun crossOff(calledNumber: UInt): BingoCard {
        return this.copy(calledNumbers =  calledNumbers + calledNumber)
    }

    fun calculateScore(): UInt {
        return totalUncalledNumbers() * calledNumbers.last()
    }

    private fun totalUncalledNumbers(): UInt {
        return rows.flatMap { it.numbers }.filter { !calledNumbers.contains(it) }.sum()
    }
}