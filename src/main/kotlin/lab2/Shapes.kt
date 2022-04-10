package lab2

import kotlin.math.sqrt

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

class Square(
    override val fillColor: ColorAndTransparency,
    override val borderColor: ColorAndTransparency,
    private val side: Double
) : ColoredShape2d {
    init {
        if (side <= 0)
            throw IllegalArgumentException("Square doesn't exist")
    }

    override fun calcArea(): Double {
        return side * side
    }

    override fun toString(): String {
        return "Square (fillColor = $fillColor, borderColor = $borderColor, side = $side)"
    }
}

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

class Triangle(
    override val fillColor: ColorAndTransparency,
    override val borderColor: ColorAndTransparency,
    private val side1: Double, private val side2: Double, private val side3: Double
) : ColoredShape2d {
    init {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0)
            throw IllegalArgumentException("Triangle doesn't exist")
    }

    override fun calcArea(): Double {
        val semiPerimeter = (side1 + side2 + side3) / 2
        return sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3))
    }

    override fun toString(): String {
        return "Triangle (fillColor = $fillColor, borderColor = $borderColor, side1 = $side1, side2 = $side2, side3 = $side3)"
    }
}