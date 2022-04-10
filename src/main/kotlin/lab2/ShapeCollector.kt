package lab2

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

    fun sumArea(): Double {
        return shapeList.sumOf {it.calcArea()}
    }

    fun searchByFill(color: ColorAndTransparency): List<ColoredShape2d> {
        if (shapeList.isEmpty()) return emptyList()
        return shapeList.filter { it.fillColor == color }
    }

    fun searchByBorder(color: ColorAndTransparency): List<ColoredShape2d> {
        if (shapeList.isEmpty()) return emptyList()
        return shapeList.filter { it.borderColor == color }
    }

    fun getList(): List<ColoredShape2d> {
        return shapeList
    }

    fun getListSize(): Int {
        return shapeList.size
    }

    fun searchForGroupByFillColor(): Map<ColorAndTransparency, List<ColoredShape2d>> {
        return shapeList.groupBy { it.fillColor }
    }

    fun searchForGroupByBorderColor(): Map<ColorAndTransparency, List<ColoredShape2d>> {
        return shapeList.groupBy { it.borderColor }
    }

    fun searchForGroupOfAnyTypes(groupName : String) : List<ColoredShape2d>
    {
        return shapeList.filter {it::class.simpleName == groupName}
    }
}