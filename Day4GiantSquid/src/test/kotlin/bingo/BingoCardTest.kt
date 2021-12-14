package bingo

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BingoCardTest {

    private val bingoCard = BingoCard(
        Row(14u, 21u, 17u, 24u, 4u),
        Row(10u, 16u, 15u, 9u, 19u),
        Row(18u, 8u, 23u, 26u, 20u),
        Row(22u, 11u, 13u, 6u, 5u),
        Row(2u, 0u, 12u, 3u, 7u)
    )

    @Test
    fun hasNotWonIfNoNumbersFilledIn() {
        assertEquals(false, bingoCard.hasWon())
    }

    @Test
    fun hasWonIfRowFilledIn() {
        val crossedOfBingoBoard = arrayOf(14u, 21u, 17u, 24u, 4u).fold(bingoCard) { bingoBoard, calledNumber -> bingoBoard.crossOff(calledNumber)}
        assertEquals(true, crossedOfBingoBoard.hasWon())
    }

    @Test
    fun hasWonIfColumnFilledIn() {
        val crossedOfBingoBoard = arrayOf(14u, 10u, 18u, 22u, 2u).fold(bingoCard) { bingoBoard, calledNumber -> bingoBoard.crossOff(calledNumber)}
        assertEquals(true, crossedOfBingoBoard.hasWon())
    }
}
