package lanternfish

data class Lanternfish(private val daysRemaining: UInt) {

    fun gestate(): Collection<Lanternfish> {
        return if (this.daysRemaining != 0u) {
            arrayListOf(Lanternfish(daysRemaining - 1u))
        }else {
            arrayListOf(Lanternfish(6u), Lanternfish(8u))
        }
    }

}