package lab2

import lab2.colorAndTransparency.ColorAndTransparency
import lab2.shapeInterfaces.ColoredShape2d

class ShapeCollector {
    private val shapeList: MutableList<ColoredShape2d> = mutableListOf()

    fun addShape(shape: ColoredShape2d) {
        shapeList.add(shape)
    }

    fun minArea(): List<ColoredShape2d> {
        if (shapeList.isEmpty()) return emptyList()
        val minArea = shapeList.minOf { it.calcArea() }
        return shapeList.filter { it.calcArea() == minArea }
    }

    fun maxArea(): List<ColoredShape2d> {
        if (shapeList.isEmpty()) return emptyList()
        val maxArea = shapeList.maxOf { it.calcArea() }
        return shapeList.filter { it.calcArea() == maxArea }
    }

    fun searchByFill(color: ColorAndTransparency): List<ColoredShape2d> {
        if (shapeList.isEmpty()) return emptyList()
        return shapeList.filter { it.fillColor == color }
    }

    fun searchByBorder(color: ColorAndTransparency): List<ColoredShape2d> {
        if (shapeList.isEmpty()) return emptyList()
        return shapeList.filter { it.borderColor == color }
    }

    fun sumArea() = shapeList.sumOf { it.calcArea() }

    fun getList() = shapeList

    fun getListSize() = shapeList.size

    fun searchForGroupByFillColor() = shapeList.groupBy { it.fillColor }

    fun searchForGroupByBorderColor() = shapeList.groupBy { it.borderColor }

    fun searchForGroupOfAnyTypes(groupName: String) = shapeList.filter { it::class.simpleName == groupName }
}