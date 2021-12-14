package diagnostics

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class DiagnosticsTest {

    var binaryDiagnostics =
        BitMatrix(
            listOf(
                toBitList(0u, 0u, 1u, 0u, 0u),
                toBitList(1u, 1u, 1u, 1u, 0u),
                toBitList(1u, 0u, 1u, 1u, 0u),
                toBitList(1u, 0u, 1u, 1u, 1u),
                toBitList(1u, 0u, 1u, 0u, 1u),
                toBitList(0u, 1u, 1u, 1u, 1u),
                toBitList(0u, 0u, 1u, 1u, 1u),
                toBitList(1u, 1u, 1u, 0u, 0u),
                toBitList(1u, 0u, 0u, 0u, 0u),
                toBitList(1u, 1u, 0u, 0u, 1u),
                toBitList(0u, 0u, 0u, 1u, 0u),
                toBitList(0u, 1u, 0u, 1u, 0u)
            )
        )

    @Test
    fun calculateGammaRate() {
        assertEquals(22u, gammaRate(binaryDiagnostics))
    }

    @Test
    fun calculateEpsilonRate() {
        assertEquals(9u, epsilonRate(binaryDiagnostics))
    }

    @Test
    fun calculateOxygenGenerationRate() {
        assertEquals(23u, oxygenGenerationRate(binaryDiagnostics))
    }

    @Test
    fun calculateCO2ScrubberRate() {
        assertEquals(10u, co2ScrubberRate(binaryDiagnostics))
    }
}