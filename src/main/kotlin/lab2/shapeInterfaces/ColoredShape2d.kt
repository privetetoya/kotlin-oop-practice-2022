package lab2.shapeInterfaces

import lab2.colorAndTransparency.ColorAndTransparency

interface ColoredShape2d : Shape2d {
    val borderColor: ColorAndTransparency
    val fillColor: ColorAndTransparency
}
