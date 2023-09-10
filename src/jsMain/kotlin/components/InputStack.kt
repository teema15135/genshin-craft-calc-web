package components

import Item
import csstype.AlignSelf
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.useEffect
import react.useState

external interface InputStackProps : Props {
    var initialValue: Item
    var onChange: (Item) -> Unit
}

val InputStack = FC<InputStackProps> { props ->
    var twoStarAmount by useState(props.initialValue.twoStar)
    var threeStarAmount by useState(props.initialValue.threeStar)
    var fourStarAmount by useState(props.initialValue.fourStar)
    var fiveStarAmount by useState(props.initialValue.fiveStar)

    useEffect(twoStarAmount, threeStarAmount, fourStarAmount, fiveStarAmount) {
        props.onChange(Item(twoStarAmount, threeStarAmount, fourStarAmount, fiveStarAmount))
    }

    div {
        css {
            alignSelf = AlignSelf.center
        }
        InputItem {
            itemAmount = twoStarAmount
            onChange = { twoStarAmount = it }
        }
        InputItem {
            itemAmount = threeStarAmount
            onChange = { threeStarAmount = it }
        }
        InputItem {
            itemAmount = fourStarAmount
            onChange = { fourStarAmount = it }
        }
        InputItem {
            itemAmount = fiveStarAmount
            onChange = { fiveStarAmount = it }
        }
    }
}
