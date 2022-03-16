package lab1

class Book(val title: String, val author: List<String>, val year: Int) {
    override fun toString(): String {
        return "Book(title='$title', author=$author, year=$year)"
    }
}