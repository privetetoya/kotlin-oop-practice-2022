package lab2.shapes

import lab2.colorAndTransparency.ColorAndTransparency
import lab2.shapeInterfaces.ColoredShape2d

class Square(
    override val fillColor: ColorAndTransparency,
    override val borderColor: ColorAndTransparency,
    private val side: Double
) : ColoredShape2d {
    init {
        if (side <= 0) throw IllegalArgumentException("Square doesn't exist")
    }

    override fun calcArea(): Double {
        return side * side
    }

    override fun toString(): String {
        return "Square (fillColor = $fillColor, borderColor = $borderColor, side = $side)"
    }
}