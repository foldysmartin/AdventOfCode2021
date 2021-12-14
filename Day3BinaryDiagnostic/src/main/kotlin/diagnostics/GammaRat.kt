package diagnostics

fun gammaRate(bitMatrix: BitMatrix): UInt {
    return bitMatrix.mostCommonBits().toUInt()
}