import csstype.AlignContent
import csstype.Display
import csstype.FlexDirection
import csstype.Padding
import csstype.pc
import csstype.rem
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.div

val App = FC<Props> {
    fun onHavingAmountChange(item: Item) {
        println("having: $item")
    }

    fun onNeededAmountChange(item: Item) {
        println("needed: $item")
    }

    div {
        css {
            height = 100.pc
            display = Display.flex
            flexDirection = FlexDirection.column
            alignContent = AlignContent.center
            padding = Padding(5.rem, 5.rem)
        }
        InputStack {
            initialValue = Item(twoStar = 1, threeStar = 9, fourStar = 9, fiveStar = 6)
            onChange = ::onHavingAmountChange
        }
        InputStack {
            initialValue = Item(twoStar = 1, threeStar = 9, fourStar = 9, fiveStar = 6)
            onChange = ::onNeededAmountChange
        }
    }
}
