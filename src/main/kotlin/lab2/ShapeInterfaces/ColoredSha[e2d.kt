package lab2.ShapeInterfaces

import lab2.ColorAndTransparency.ColorAndTransparency

interface ColoredShape2d : Shape2d {
    val borderColor: ColorAndTransparency
    val fillColor: ColorAndTransparency
}
