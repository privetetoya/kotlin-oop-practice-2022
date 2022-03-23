package lab1

fun parseBooks(books: String): List<Book> {//implementing a parser
    val separator = "//"
    val comma = ','
    val point = '.'
    val bookList = mutableListOf<Book>()
    val listOfBookLines = books.lines().toMutableList()
    (0 until ((listOfBookLines.size))).forEach { i ->
        val authors = mutableListOf<String>()
        listOfBookLines[i] = listOfBookLines[i].substringAfter(point)   //take string after point

        val title: String = listOfBookLines[i].substringBefore(separator).trim()    // take string between N. and //
        listOfBookLines[i] = listOfBookLines[i].substringAfter(separator) //take string after first separator

        if (listOfBookLines[i].substringBefore(separator).trim()
                .isNotEmpty()
        ) { //take authors between separator and comma
            while (listOfBookLines[i].contains(comma)) {
                authors.add(listOfBookLines[i].substringBefore(comma).trim())
                listOfBookLines[i] = listOfBookLines[i].substringAfter(comma)

            }
            authors.add(
                listOfBookLines[i].substringBefore(separator).trim()
            ) //take author between last comma and separator
            listOfBookLines[i] = listOfBookLines[i].substringAfter(separator)
        }

        val year: Int = listOfBookLines[i].filter { it.isDigit() }.toInt() // take year of book
        bookList.add(Book(title, authors, year))
    }
    return bookList
}