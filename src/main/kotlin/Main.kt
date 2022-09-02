import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.max


fun main() {
    val shapeMaker = ShapeMaker(10, 20)
    shapeMaker.drawCircle()
    shapeMaker.drawRectangle()
    shapeMaker.drawSquare()
}

class ShapeMaker(val height : Int, val width : Int){
    val circle  = Circle()
    val rectangle = Rectangle()
    val square = Square()

    fun drawCircle(){
        circle.draw()
    }
    fun drawRectangle(){
        rectangle.draw()
    }
    fun drawSquare(){
        square.draw()
    }
}