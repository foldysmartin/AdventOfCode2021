import java.io.File

fun main() {
    val arrayList =  File("src", "depth_measurements.txt").readLines().map{it.toUInt()}
    println(largestNumberDepthMeasurementIncreasesOverThreeMeasurements(arrayList))
}

fun largestNumberOfSequentialDepthMeasurementIncreases(depthArray: Collection<UInt>): Int {
    return depthArray.windowed(2).count{(a, b) -> a < b}
}

fun largestNumberDepthMeasurementIncreasesOverThreeMeasurements(depthArray: Collection<UInt>): Int {
    //Comparing the Sum of A + B + C to the Sum of B + C + D is the same as comparing A and D
    return depthArray.windowed(4).count{it[0] < it[3]}
}