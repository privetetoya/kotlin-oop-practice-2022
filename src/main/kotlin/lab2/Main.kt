package lab2

import lab2.colorAndTransparency.ColorAndTransparency
import lab2.shapes.Circle
import lab2.shapes.Rectangle
import lab2.shapes.Square
import lab2.shapes.Triangle

fun main() {
    val color1 = ColorAndTransparency(1, 1, 1, 1)
    val color2 = ColorAndTransparency(50, 50, 50, 50)
    val color3 = ColorAndTransparency(150, 150, 150, 90)
    val shapeCollector = ShapeCollector()

    val circle = Circle(color1, color2, 5.0)
    val square = Square(color1, color3, 4.0)
    val rectangle = Rectangle(color2, color3, 3.0, 4.0)
    val triangle = Triangle(color3, color1, 3.0, 4.0, 5.0)

    shapeCollector.addShape(circle)
    shapeCollector.addShape(square)
    shapeCollector.addShape(rectangle)
    shapeCollector.addShape(triangle)

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