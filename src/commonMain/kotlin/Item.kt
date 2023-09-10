data class Item(
    val twoStar: Int,
    val threeStar: Int,
    val fourStar: Int,
    val fiveStar: Int
) {
    data class Enough(val twoStar: Boolean, val threeStar: Boolean, val fourStar: Boolean, val fiveStar: Boolean) {
        val all: Boolean = twoStar && threeStar && fourStar && fiveStar
    }

    fun enough(needed: Item): Enough = Enough(
        twoStar = twoStar >= needed.twoStar,
        threeStar = threeStar >= needed.threeStar,
        fourStar = fourStar >= needed.fourStar,
        fiveStar = fiveStar >= needed.fiveStar
    )
}
