package diagnostics

enum class Bit(internal val number: Int) {
    Zero(0),
    One(1)
}

internal fun List<Bit>.toUInt(): UInt {
    return this.map { it.number }
        .joinToString { it.toString() }
        .replace(" ", "")
        .replace(",", "")
        .toUInt(2)
}

fun toBitList(vararg input: UInt): List<Bit> {
    return toBitList(input)
}

fun toBitList(input: Collection<UInt>): List<Bit> {
    assert(input.any { it == 1u || it == 0u }) { -> "Input contains values other than 1 or 0" }
    return input.map { Bit.values()[it.toInt()] }
}