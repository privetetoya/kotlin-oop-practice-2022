package lab2

import lab2.ColorAndTransparency.ColorAndTransparency
import lab2.Shapes.Circle
import lab2.Shapes.Rectangle
import lab2.Shapes.Square
import lab2.Shapes.Triangle

fun main() {
    val color1 = ColorAndTransparency(1, 1, 1, 1)
    val color2 = ColorAndTransparency(50, 50, 50, 50)
    val color3 = ColorAndTransparency(150, 150, 150, 90)
    val shapeCollector = ShapeCollector()

    val circle = shapeCollector.addShape(Circle(color1, color2, 5.0))
    val square = shapeCollector.addShape(Square(color1, color3, 4.0))
    val rectangle = shapeCollector.addShape(Rectangle(color2, color3, 3.0, 4.0))
    val triangle = shapeCollector.addShape(Triangle(color3, color1, 3.0, 4.0, 5.0))

    println("Shape collection consists of: ${shapeCollector.getList()}")
    println("Size of shape collection: ${shapeCollector.getListSize()} ")
    println("Shapes with minimal area: ${shapeCollector.minArea()}")
    println("Shapes with maximum area: ${shapeCollector.maxArea()}")
    println("Amount of all shapes areas: ${shapeCollector.sumArea()}")
    println("Shapes with color 1 in Fill ${shapeCollector.searchByFill(color1)}")
    println("Shapes with color 3 in Border ${shapeCollector.searchByBorder(color3)}")
    println("Group of shapes by Fill color ${shapeCollector.searchForGroupByFillColor()}")
    println("Group of shapes by Border color ${shapeCollector.searchForGroupByBorderColor()}")
    println("Group of shapes by type ${shapeCollector.searchForGroupOfAnyTypes("Circle")}")

}