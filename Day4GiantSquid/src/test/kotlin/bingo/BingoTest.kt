package bingo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BingoTest {
    private val winningCard = BingoCard(
        Row(14u, 21u, 17u, 24u, 4u),
        Row(10u, 16u, 15u, 9u, 19u),
        Row(18u, 8u, 23u, 26u, 20u),
        Row(22u, 11u, 13u, 6u, 5u),
        Row(2u, 0u, 12u, 3u, 7u)
    )

    private val middleCard = BingoCard(
        Row(22u, 13u, 17u, 11u, 0u),
        Row(8u, 2u, 23u, 4u, 24u),
        Row(21u, 9u, 14u, 16u, 7u),
        Row(6u, 10u, 3u, 18u, 5u),
        Row(1u, 12u, 20u, 15u, 19u)
    )

    private val losingCard = BingoCard(
        Row(3u, 15u, 0u, 2u, 22u),
        Row(9u, 18u, 13u, 17u, 5u),
        Row(19u, 8u, 7u, 25u, 23u),
        Row(20u, 11u, 10u, 24u, 4u),
        Row(14u, 21u, 16u, 12u, 6u)
    )

    private val bingoCards = listOf(
        middleCard,
        losingCard,
        winningCard
    )

    private val calledNumbers = listOf(
        7u,
        4u,
        9u,
        5u,
        11u,
        17u,
        23u,
        2u,
        0u,
        14u,
        21u,
        24u,
        10u,
        16u,
        13u,
        6u,
        15u,
        25u,
        12u,
        22u,
        18u,
        20u,
        8u,
        19u,
        3u,
        26u,
        1u
    )

    @Test
    fun playBingoReturnsBoardsInWinningOrder() {
        assertEquals(listOf(winningCard, middleCard, losingCard), playBingo(calledNumbers, bingoCards))
        assertEquals(4512u, playBingo(calledNumbers, bingoCards).first().calculateScore())
        assertEquals(1924u, playBingo(calledNumbers, bingoCards).last().calculateScore())
    }
}