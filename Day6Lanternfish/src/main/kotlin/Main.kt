import lanternfish.Lanternfish
import lanternfish.School
import java.io.File

fun main(args: Array<String>) {
    val fish = File("src", "startingSchool.txt").readLines()
        .flatMap { it.split(',') }
        .map { it.trim() }
        .map { Lanternfish(it.toUInt()) }

    val school = School(fish)
    println("After 80 days there are ${school.gestate(80u).size} fish")
    println("After 256 days there are ${school.gestate(256u).size} fish")
}