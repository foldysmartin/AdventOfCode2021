import diagnostics.*
import java.io.File

fun main(args: Array<String>) {

    val bitArrays =
        File("src", "binaryDiagnostics.txt").readLines()
            .map { line ->
                line.toCharArray()
                    .map { it.toString().toUInt() }
            }
            .map { toBitList(it) }

    var bitMatrix = BitMatrix(bitArrays)

    println("Submarine power consumption ${gammaRate(bitMatrix) * epsilonRate(bitMatrix)}")
    println("Submarine life support rating ${oxygenGenerationRate(bitMatrix) * co2ScrubberRate(bitMatrix)}")
}