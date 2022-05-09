package lab5

import lab2.colorAndTransparency.ColorAndTransparency
import lab2.shapeInterfaces.ColoredShape2d
import lab5.comparator.AreaComparator
import lab5.shapeCollector.ShapeCollector
import lab2.shapes.Circle
import lab2.shapes.Rectangle
import lab2.shapes.Square
import lab2.shapes.Triangle

fun main() {

    //colors
    val color1 = ColorAndTransparency(1, 1, 1, 1)
    val color2 = ColorAndTransparency(50, 50, 50, 50)
    val color3 = ColorAndTransparency(150, 150, 150, 90)
    val shapeCollector = ShapeCollector<ColoredShape2d>()
    //shapes
    val circle = Circle(color1, color2, 5.0)
    val square = Square(color1, color3, 4.0)
    val rectangle = Rectangle(color2, color3, 3.0, 4.0)
    val triangle = Triangle(color3, color1, 3.0, 4.0, 5.0)


    shapeCollector.addShape(circle)
    shapeCollector.addShape(triangle)
    shapeCollector.addShape(rectangle)
    shapeCollector.addShape(square)

    println("Shape collection consists of: ${shapeCollector.getListOfShapes()}\n")
    println("Size of shape collection: ${shapeCollector.getListSize()} ")
    println("Area of circle = " + circle.calcArea())
    println("Area of triangle = " + triangle.calcArea())
    println("Area of rectangle = " + rectangle.calcArea())
    println("Area of square = " + square.calcArea())

    println("\nShape with max area: ${shapeCollector.maxArea()}\n")
    println("Shape with min area: ${shapeCollector.minArea()}\n")
    println("Total area size: ${shapeCollector.sumAreas()}\n")

    println("Shapes with color 1 in Fill:\n ${shapeCollector.fillColor(color1)}\n")
    println("Shapes with color 3 in Border:\n ${shapeCollector.borderColor(color3)}\n")
    println("Group of shapes by Border color = ${shapeCollector.groupByBorderColor()}\n")
    println("Group of shapes by Fill color = ${shapeCollector.groupByFillColor()}\n")
    println("Group of shapes by type = ${shapeCollector.searchForGroupOfAnyTypes()}\n")
    println("Sorted by area: ${shapeCollector.getSorted(AreaComparator())}")

}