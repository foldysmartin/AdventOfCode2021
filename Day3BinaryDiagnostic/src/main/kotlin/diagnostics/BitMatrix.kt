package diagnostics

class BitMatrix {

    constructor(bits: List<List<Bit>>) {
        val width = bits[0].size
        assert(bits.all { it.size == width })
        matrix = bits
    }

    internal val height: UInt
        get() = matrix.size.toUInt()
    private val matrix: List<List<Bit>>


    internal fun first(): List<Bit> {
        return matrix.first()
    }

    internal fun filterRows(filter: (bitRow: List<Bit>) -> Boolean): BitMatrix {
        return BitMatrix(matrix.filter { filter(it) })
    }

    internal fun mostCommonBits(): List<Bit> {
        //If same number of 0 and 1s return 1
        return verticalCount().map { bitCount ->
            bitCount.toSortedMap(compareBy { -it.number }).maxByOrNull { it.value }?.key
                ?: Bit.One
        }
    }

    internal fun leastCommonBits(): List<Bit> {
        //If same number of 0 and 1s return 0
        return verticalCount().map { bitCount ->
            bitCount.toSortedMap(compareBy { it.number }).minByOrNull { it.value }?.key
                ?: Bit.Zero
        }
    }

    private fun verticalCount(): List<Map<Bit, Int>> {
        return transpose().map { bitArray -> bitArray.groupingBy { it }.eachCount() }
    }

    private fun transpose(): List<List<Bit>> {
        return (0 until matrix[0].size).map { index -> matrix.map { byteArray -> byteArray[index] } }
    }
}

