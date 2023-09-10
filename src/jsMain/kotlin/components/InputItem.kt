package components

import ColorConst
import csstype.rem
import emotion.react.css
import org.w3c.dom.HTMLInputElement
import react.FC
import react.Props
import react.dom.events.ChangeEvent
import react.dom.html.InputMode
import react.dom.html.InputType
import react.dom.html.ReactHTML.input

external interface InputItemProps : Props {
    var itemAmount: Int
    var onChange: (Int) -> Unit
}

val InputItem = FC<InputItemProps> { props ->
    fun String.filterNonNumeric(): String = replace(Regex("\\D"), "")

    fun handleInputChange(it: ChangeEvent<HTMLInputElement>) {
        it.target.value
            .filterNonNumeric()
            .ifBlank { "0" }
            .toInt()
            .let { props.onChange(it) }
    }

    input {
        css {
            width = 10.rem
            fontSize = 3.rem
            color = ColorConst.primaryNavy
        }
        type = InputType.text
        inputMode = InputMode.numeric
        value = props.itemAmount.toString()
        onChange = ::handleInputChange
    }
}
