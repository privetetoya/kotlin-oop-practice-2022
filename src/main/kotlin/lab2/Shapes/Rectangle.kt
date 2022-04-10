package lab2.Shapes

import lab2.ColorAndTransparency.ColorAndTransparency
import lab2.ShapeInterfaces.ColoredShape2d

class Rectangle(
    override val fillColor: ColorAndTransparency,
    override val borderColor: ColorAndTransparency,
    private val height: Double, private val width: Double
) : ColoredShape2d {
    init {
        if (height <= 0 || width <= 0)
            throw IllegalArgumentException("Rectangle doesn't exist")
    }

    override fun calcArea(): Double {
        return height * width
    }

    override fun toString(): String {
        return "Rectangle (fillColor = $fillColor, borderColor = $borderColor, height = $height, width = $width)"
    }
}