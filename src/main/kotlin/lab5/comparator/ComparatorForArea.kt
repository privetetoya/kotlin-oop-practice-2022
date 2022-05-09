package lab5.comparator

import lab2.shapeInterfaces.ColoredShape2d
class AreaComparator : Comparator<ColoredShape2d> {
    override fun compare(firstShape: ColoredShape2d, secondShape: ColoredShape2d): Int {
        if (firstShape.calcArea() > secondShape.calcArea()) {
            return 1
        }
        if (firstShape.calcArea() < secondShape.calcArea()) {
            return -1
        }
        return 0
    }
}