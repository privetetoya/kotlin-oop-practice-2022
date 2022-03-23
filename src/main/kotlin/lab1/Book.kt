package lab1

class Book(val title: String, val authors: List<String>, val year: Int) {
    override fun toString(): String {
        return "Book(title='$title', author=$authors, year=$year)"
    }
}