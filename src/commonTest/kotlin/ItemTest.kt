import kotlin.test.Test
import kotlin.test.assertEquals

class ItemTest {
    @Test
    fun test1() {
        val having = "1 9 9 6".toItem()
        val needed = "1 9 9 6".toItem()
        val expected = Item.Enough(twoStar = true, threeStar = true, fourStar = true, fiveStar = true)
        assertEquals(expected, having.enough(needed))
    }

    @Test
    fun test2() {
        val having = "1 9 8 0".toItem()
        val needed = "1 9 9 6".toItem()
        val expected = Item.Enough(twoStar = true, threeStar = true, fourStar = false, fiveStar = false)
    }

    private fun String.toItem(): Item {
        val split = split(" ").map { it.toInt() }
        return Item(split[0], split[1], split[2], split[3])
    }
}
