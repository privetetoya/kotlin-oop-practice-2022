package lab2

class ColorAndTransparency(
    private val red: Int,
    private val green: Int,
    private val blue: Int,
    private val transparency: Int
) {
    init {
        if (red !in 0..255 || green !in 0..255 || blue !in 0..255 || transparency !in 0..100) {
            throw IllegalArgumentException("Incorrect data for Color and Transparency")
        }
    }

    override fun toString(): String {
        return "Color and Transparency (red = $red, green = $green, blue = $blue, transparency = $transparency)"
    }
}