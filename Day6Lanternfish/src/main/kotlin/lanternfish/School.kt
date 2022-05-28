package lanternfish

class School {
    private val mapOfFish: Map<Lanternfish, ULong>

    constructor(collection: Collection<Lanternfish>) {
        this.mapOfFish = collection.groupingBy { it }.eachCount().map { Pair(it.key, it.value.toULong()) }.toMap()
    }

    private constructor(mapOfFish: Map<Lanternfish, ULong>) {
        this.mapOfFish = mapOfFish
    }

    val size: ULong
        get() {
            return mapOfFish.values.sum()
        }

    fun gestate(days: UInt): School {
        return (0u until days).fold(this) { school, _ ->
            school.gestate()
        }
    }

    fun gestate(): School {
        return School(gestationMultiplied().mergeFish())
    }

    private fun gestationMultiplied(): List<Pair<Lanternfish, ULong>> {
        return mapOfFish.flatMap {
            it.key.gestate().map { lanternfish -> Pair(lanternfish, it.value) }
        }
    }

}

private fun List<Pair<Lanternfish, ULong>>.mergeFish(): Map<Lanternfish, ULong> {
    return this.groupBy { it.first }
        .map { it.value.reduce { acc, pair -> pair.copy(second = pair.second + acc.second) } }
        .toMap()
}