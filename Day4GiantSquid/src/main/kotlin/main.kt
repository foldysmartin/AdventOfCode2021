import bingo.BingoCard
import bingo.Row
import bingo.playBingo
import java.io.File

fun main(args: Array<String>) {
    val bingoNumbers = File("src", "bingoCards.txt").readLines().first().split(',').map { it.toUInt() }
    val bingoCards = File("src", "bingoCards.txt").readLines().drop(1).windowed(6,6).map {
        BingoCard(
            it[1].bingoRow(),
            it[2].bingoRow(),
            it[3].bingoRow(),
            it[4].bingoRow(),
            it[5].bingoRow(),
        )
    };
    println("The winning bingo card has a score of ${playBingo(bingoNumbers, bingoCards).first().calculateScore()}")
    println("The losing bingo card has a score of ${playBingo(bingoNumbers, bingoCards).last().calculateScore()}")
}

private fun String.bingoRow(): Row {
    return Row(this.trimStart().replace("  ",  " ").split(' ').map{ numberString -> numberString.toUInt()})
}
