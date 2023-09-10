package components

import CalculatedResult
import csstype.AlignSelf
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.div

external interface ResultStackProps : Props {
    var result: CalculatedResult
}

val ResultStack = FC<ResultStackProps> { props ->
    div {
        css {
            alignSelf = AlignSelf.center
        }
        ResultItem {
            value = props.result.craftResult.twoStar
            isEnough = props.result.enough.twoStar
        }
        ResultItem {
            value = props.result.craftResult.threeStar
            isEnough = props.result.enough.threeStar
        }
        ResultItem {
            value = props.result.craftResult.fourStar
            isEnough = props.result.enough.fourStar
        }
        ResultItem {
            value = props.result.craftResult.fiveStar
            isEnough = props.result.enough.fiveStar
        }
    }
}
