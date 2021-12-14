package bingo

//Returns bingo cards in winning order
fun playBingo(numbers: List<UInt>, cards: List<BingoCard>): List<BingoCard> {
    return playRound(numbers, cards).toList()

}

private fun playRound(numbers: List<UInt>, cards: List<BingoCard>): Sequence<BingoCard> =  sequence {
    if (cards.isAWinner()) {
        yield(cards.first { it.hasWon() })
    }

    when (cards.isEmpty()) {
        true -> { }
        false -> yieldAll(playRound(numbers.drop(1), cards.crossOff(numbers.first())))
    }
}

private fun List<BingoCard>.isAWinner(): Boolean {
    return this.any{it.hasWon()}
}

private fun List<BingoCard>.crossOff(number: UInt): List<BingoCard> {
    return this.filter { !it.hasWon() }.map{it.crossOff(number)}
}