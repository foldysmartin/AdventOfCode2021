package diagnostics

fun oxygenGenerationRate(bitMatrix: BitMatrix): UInt {
    return filterByMostCommonRemaining(bitMatrix, 0).first().toUInt()
}

private fun filterByMostCommonRemaining(bitMatrix: BitMatrix, index: Int): BitMatrix {
    if (bitMatrix.height <= 1u) return bitMatrix
    return filterByMostCommonRemaining(
        bitMatrix.filterRows { it[index] == bitMatrix.mostCommonBits()[index] },
        index + 1
    )
}
