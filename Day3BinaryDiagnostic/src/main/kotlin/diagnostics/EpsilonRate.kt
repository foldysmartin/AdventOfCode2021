package diagnostics

fun epsilonRate(bitMatrix: BitMatrix): UInt {
    return bitMatrix.leastCommonBits().toUInt()
}

