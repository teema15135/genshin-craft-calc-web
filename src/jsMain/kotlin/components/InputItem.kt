package components

import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.input

external interface InputItemProps : Props {
    var itemAmount: Int
    var onChange: (Int) -> Unit
}

val InputItem = FC<InputItemProps> { props ->
    input {
        type = InputType.number
        min = 0.0
        step = 1.0
        value = props.itemAmount.toString()
        onChange = { props.onChange(it.target.value.toInt()) }
    }
}
