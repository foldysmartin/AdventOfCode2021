package diagnostics

fun co2ScrubberRate(bitMatrix: BitMatrix): UInt {
    return filterByLeastCommonRemaining(bitMatrix, 0).first().toUInt()
}

private fun filterByLeastCommonRemaining(bitMatrix: BitMatrix, index: Int): BitMatrix {
    if (bitMatrix.height <= 1u) return bitMatrix
    return filterByLeastCommonRemaining(
        bitMatrix.filterRows { it[index] == bitMatrix.leastCommonBits()[index] },
        index + 1
    )
}