import components.InputStack
import components.ResultStack
import csstype.AlignContent
import csstype.Display
import csstype.FlexDirection
import csstype.Padding
import csstype.TextAlign
import csstype.pc
import csstype.rem
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.useEffect
import react.useState

val App = FC<Props> {
    val calculator = CraftingCalculator()

    var havingItem by useState(Item(twoStar = 1, threeStar = 9, fourStar = 9, fiveStar = 6))
    var neededItem by useState(Item(twoStar = 1, threeStar = 9, fourStar = 9, fiveStar = 6))
    var resultItem by useState<CalculatedResult?>(null)

    fun calculateCrafting() {
        resultItem = calculator.calculate(havingItem, neededItem)
    }

    fun onHavingAmountChange(item: Item) {
        havingItem = item
    }

    fun onNeededAmountChange(item: Item) {
        neededItem = item
    }

    useEffect(havingItem, neededItem) {
        calculateCrafting()
    }

    div {
        css {
            height = 100.pc
            display = Display.flex
            flexDirection = FlexDirection.column
            alignContent = AlignContent.center
            textAlign = TextAlign.center
            padding = Padding(5.rem, 5.rem)
            fontSize = 2.rem
        }
        div {
            +"Having"
        }
        InputStack {
            initialValue = Item(twoStar = 1, threeStar = 9, fourStar = 9, fiveStar = 6)
            onChange = ::onHavingAmountChange
        }
        div {
            +"Needed"
        }
        InputStack {
            initialValue = Item(twoStar = 1, threeStar = 9, fourStar = 9, fiveStar = 6)
            onChange = ::onNeededAmountChange
        }
        div {
            +"Result"
        }
        resultItem?.let {
            ResultStack {
                result = it
            }
        }
    }
}
