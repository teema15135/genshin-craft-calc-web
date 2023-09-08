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
        assertEquals(CalculatedResult.Complete, actual)
    }

    @Test
    fun lackOfTwoStar() {
        val actual = calculator.calculate("0 9 9 6".toItem(), "1 9 9 6".toItem())
        assertEquals(CalculatedResult.LackOfTwoStar, actual)
    }

    @Test
    fun lackOfThreeStar() {
        val actual = calculator.calculate("3 8 9 6".toItem(), "1 9 9 6".toItem())
        assertEquals(CalculatedResult.LackOfThreeStar, actual)
    }

    @Test
    fun lackOfFourStar() {
        val actual = calculator.calculate("4 8 8 6".toItem(), "1 9 9 6".toItem())
        assertEquals(CalculatedResult.LackOfFourStar, actual)
    }

    @Test
    fun lackOfFiveStar() {
        val actual = calculator.calculate("4 11 8 5".toItem(), "1 9 9 6".toItem())
        assertEquals(CalculatedResult.LackOfFiveStar, actual)
    }

    private fun String.toItem(): Item {
        val split = split(" ").map { it.toInt() }
        return Item(split[0], split[1], split[2], split[3])
    }
}
