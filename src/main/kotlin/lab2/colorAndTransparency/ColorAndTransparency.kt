package lab2.colorAndTransparency

data class ColorAndTransparency(
    val red: Int, val green: Int, val blue: Int, val transparency: Int
) {
    init {
        if (red !in 0..255) throw IllegalArgumentException("Incorrect data for Color red")
        if (green !in 0..255) throw IllegalArgumentException("Incorrect data for Color green")
        if (blue !in 0..255) throw IllegalArgumentException("Incorrect data for Color blue")
        if (transparency !in 0..100) throw IllegalArgumentException("Incorrect data for Transparency")

    }

    override fun toString(): String {
        return "Color and Transparency (red = $red, green = $green, blue = $blue, transparency = $transparency)"
    }
}