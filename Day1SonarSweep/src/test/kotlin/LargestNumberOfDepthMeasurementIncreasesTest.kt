import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LargestNumberOfDepthMeasurementIncreasesTest {

    private val depthMeasurements =  uintArrayOf(199u, 200u, 208u, 210u, 200u, 207u, 240u, 269u, 260u, 263u)

    @Test
    fun returnsMaxNumberOfSequentialDecreases() {
        assertEquals(7, largestNumberOfSequentialDepthMeasurementIncreases(depthMeasurements))
    }

    @Test
    fun returnsMaxNumberOfSequentialDecreasesOver3DepthMeasurements() {
        assertEquals(5, largestNumberDepthMeasurementIncreasesOverThreeMeasurements(depthMeasurements))
    }
}