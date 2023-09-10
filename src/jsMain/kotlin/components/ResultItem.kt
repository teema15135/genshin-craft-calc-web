package components

import csstype.Border
import csstype.Color
import csstype.LineStyle
import csstype.px
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.input

external interface ResultItemProps : Props {
    var value: Int
    var isEnough: Boolean
}

val ResultItem = FC<ResultItemProps> { props ->
    input {
        css {
            border = Border(
                4.px,
                LineStyle.solid,
                if (props.isEnough) {
                    Color("green")
                } else {
                    Color("red")
                }
            )
        }
        type = InputType.number
        disabled = true
        value = props.value.toString()
    }
}
