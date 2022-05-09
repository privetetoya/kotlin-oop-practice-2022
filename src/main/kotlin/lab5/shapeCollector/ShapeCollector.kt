package lab5.shapeCollector

import lab2.shapeInterfaces.ColoredShape2d
import lab2.colorAndTransparency.ColorAndTransparency

class ShapeCollector<T : ColoredShape2d> {
    private val shapeList = mutableListOf<T>()

    //Add new shape to list
    fun addShape(shape: T) {
        shapeList.add(shape)
    }

    //Return biggest shape by area
    fun maxArea(): T? {
        return shapeList.maxByOrNull { it.calcArea() }
    }

    //Return smallest shape by area
    fun minArea(): T? {
        return shapeList.minByOrNull { it.calcArea() }
    }

    //Sum of all areas
    fun sumAreas(): Double {
        var sum = 0.0

        for (shape in shapeList) {
            sum += shape.calcArea()
        }
        return sum
    }

    //Searching by color of border
    fun borderColor(borderColor: ColorAndTransparency): List<T> = shapeList.filter { it.borderColor == borderColor }

    //Searching by fill color
    fun fillColor(fillColor: ColorAndTransparency): List<T> = shapeList.filter { it.fillColor == fillColor }

    //Searching for group by border color
    fun groupByBorderColor(): Map<ColorAndTransparency, List<T>> = shapeList.groupBy { it.borderColor }

    //Searching for group by fill color
    fun groupByFillColor(): Map<ColorAndTransparency, List<T>> = shapeList.groupBy { it.fillColor }
    fun getListOfShapes(): List<T> {
        return shapeList
    }

    //Searching for group type
    fun searchForGroupOfAnyTypes(): Map<Class<Any>, List<T>> = shapeList.groupBy { it.javaClass }
    fun getSorted(comparator: Comparator<T>): List<T> {
        val sortList = shapeList
        sortList.sortWith(comparator)
        return sortList.toList()
    }

    fun getListSize(): Int = shapeList.size
}