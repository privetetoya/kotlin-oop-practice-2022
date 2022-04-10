package lab2.Shapes

import lab2.ColorAndTransparency.ColorAndTransparency
import lab2.ShapeInterfaces.ColoredShape2d


class Circle(
    override val fillColor: ColorAndTransparency,
    override val borderColor: ColorAndTransparency,
    private val radius: Double
) : ColoredShape2d {
    init {
        if (radius <= 0)
            throw IllegalArgumentException("Circle doesn't exist")
    }

    override fun calcArea(): Double {
        return Math.PI * radius * radius
    }

    override fun toString(): String {
        return "Circle (fillColor = $fillColor, borderColor = $borderColor, radius = $radius)"
    }
}
