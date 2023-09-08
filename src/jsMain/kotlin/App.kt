import react.FC
import react.Props
import react.dom.html.ReactHTML.br
import react.dom.html.ReactHTML.h1

val App = FC<Props> {
    h1 {
        +"Hello, Traveller"
        br { }
        +"Yeah"
    }
}
