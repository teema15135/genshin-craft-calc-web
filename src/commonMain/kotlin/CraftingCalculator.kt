import kotlin.math.max

class CraftingCalculator {
    companion object {
        private const val CRAFT_USE = 3
    }

    private data class TotalItem(var two: Int, var three: Int, var four: Int, var five: Int) {
        fun toItem(): Item = Item(two, three, four, five)
    }

    fun calculate(having: Item, needed: Item): CalculatedResult {
        var total = TotalItem(having.twoStar, having.threeStar, having.fourStar, having.fiveStar)

        val craftToThreeStar = canCraftAmount(total.two, needed.twoStar) / CRAFT_USE
        total.three += craftToThreeStar
        total.two -= craftToThreeStar * CRAFT_USE

        val craftToFourStar = canCraftAmount(total.three, needed.threeStar) / CRAFT_USE
        total.four += craftToFourStar
        total.three -= craftToFourStar * CRAFT_USE

        val craftToFiveStar = canCraftAmount(total.four, needed.fourStar) / CRAFT_USE
        total.five += craftToFiveStar
        total.four -= craftToFiveStar * CRAFT_USE

        val totalItem = total.toItem()

        return CalculatedResult(totalItem, totalItem.enough(needed))
    }

    private fun canCraftAmount(having: Int, needed: Int): Int =
        max(0, having - needed)
}
