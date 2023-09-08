class CraftingCalculator {
    companion object {
        private const val CRAFT_USE = 3
    }

    fun calculate(have: Item, needed: Item): CalculatedResult {
        if (have.twoStar < needed.twoStar) {
            println("Lack of two star")
            return CalculatedResult.LackOfTwoStar
        }

        val craftedThreeStar = (have.twoStar - needed.twoStar) / CRAFT_USE
        val totalThreeStar = have.threeStar + craftedThreeStar

        if (totalThreeStar < needed.threeStar) {
            println("Lack of three star")
            return CalculatedResult.LackOfThreeStar
        }

        val craftedFourStar = (totalThreeStar - needed.threeStar) / CRAFT_USE
        val totalFourStar = have.fourStar + craftedFourStar

        if (totalFourStar < needed.fourStar) {
            println("Lack of four star")
            return CalculatedResult.LackOfFourStar
        }

        val craftedFiveStar = (totalFourStar - needed.fourStar) / CRAFT_USE
        val totalFiveStar = have.fiveStar + craftedFiveStar

        if (totalFiveStar < needed.fiveStar) {
            println("Lack of five star")
            return CalculatedResult.LackOfFiveStar
        }

        return CalculatedResult.Complete
    }
}
