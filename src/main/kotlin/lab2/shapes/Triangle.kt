package lab2.shapes

import lab2.colorAndTransparency.ColorAndTransparency
import lab2.shapeInterfaces.ColoredShape2d
import kotlin.math.sqrt


class Triangle(
    override val fillColor: ColorAndTransparency,
    override val borderColor: ColorAndTransparency,
    private val side1: Double,
    private val side2: Double,
    private val side3: Double
) : ColoredShape2d {
    init {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) throw IllegalArgumentException("Triangle doesn't exist")
    }

    override fun calcArea(): Double {
        val semiPerimeter = (side1 + side2 + side3) / 2
        return sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3))
    }

    override fun toString(): String {
        return "Triangle (fillColor = $fillColor, borderColor = $borderColor, side1 = $side1, side2 = $side2, side3 = $side3)"
    }
}