import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CraftingCalculatorTest {
    private lateinit var calculator: CraftingCalculator

    @BeforeTest
    fun setUp() {
        calculator = CraftingCalculator()
    }

    @Test
    fun complete() {
        val actual = calculator.calculate("1 9 9 6".toItem(), "1 9 9 6".toItem())
        assertEquals(CalculatedResult("1 9 9 6".toItem(), allEnough()), actual)
    }

    @Test
    fun lackOfTwoStar() {
        val actual = calculator.calculate("0 9 9 6".toItem(), "1 9 9 6".toItem())
        assertEquals(
            CalculatedResult(
                "0 9 9 6".toItem(),
                Item.Enough(twoStar = false, threeStar = true, fourStar = true, fiveStar = true)
            ),
            actual
        )
    }

    @Test
    fun lackOfThreeStar() {
        val actual = calculator.calculate("3 8 9 6".toItem(), "1 9 9 6".toItem())
        assertEquals(
            CalculatedResult(
                "3 8 9 6".toItem(),
                Item.Enough(twoStar = true, threeStar = false, fourStar = true, fiveStar = true)
            ),
            actual
        )
    }

    @Test
    fun lackOfFourStar() {
        val actual = calculator.calculate("4 8 8 6".toItem(), "1 9 9 6".toItem())
        assertEquals(
            CalculatedResult(
                "1 9 8 6".toItem(),
                Item.Enough(twoStar = true, threeStar = true, fourStar = false, fiveStar = true)
            ),
            actual
        )
    }

    @Test
    fun lackOfFiveStar() {
        val actual = calculator.calculate("4 11 8 5".toItem(), "1 9 9 6".toItem())
        assertEquals(
            CalculatedResult(
                "1 9 9 5".toItem(),
                Item.Enough(twoStar = true, threeStar = true, fourStar = true, fiveStar = false)
            ),
            actual
        )
    }

    private fun allEnough(): Item.Enough = Item.Enough(
        twoStar = true,
        threeStar = true,
        fourStar = true,
        fiveStar = true
    )

    private fun String.toItem(): Item {
        val split = split(" ").map { it.toInt() }
        return Item(split[0], split[1], split[2], split[3])
    }
}
