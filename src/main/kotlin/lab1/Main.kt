package lab1

import kotlin.math.min

fun parseBooks(books: String): List<Book> {
    val separator = "//"
    val comma = ','
    val point = '.'
    val bookList = mutableListOf<Book>()
    val listOfBookLines = books.lines().toMutableList()
    (0 until ((listOfBookLines.size))).forEach { i ->
        val authors = mutableListOf<String>()
        listOfBookLines[i] = listOfBookLines[i].substringAfter(point)

        val title: String = listOfBookLines[i].substringBefore(separator).trim()
        listOfBookLines[i] = listOfBookLines[i].substringAfter(separator)

        if (listOfBookLines[i].substringBefore(separator).trim().isNotEmpty()) {
            while (listOfBookLines[i].contains(comma)) {
                authors.add(listOfBookLines[i].substringBefore(comma).trim())
                listOfBookLines[i] = listOfBookLines[i].substringAfter(comma)

            }
            authors.add(listOfBookLines[i].substringBefore(separator).trim())
            listOfBookLines[i] = listOfBookLines[i].substringAfter(separator)
        }

        val year: Int = listOfBookLines[i].filter { it.isDigit() }.toInt()
        bookList.add(Book(title, authors, year))
    }
    return bookList
}


fun findTheOldest(bookList: List<Book>): List<Book> {
    var earliestYear: Int = Int.MAX_VALUE
    bookList.forEach {
        earliestYear = min(earliestYear, it.year)
    }
    return bookList.filter { it.year == earliestYear }
}

fun newest() {
}

fun longest() {

}

fun shortest() {

}


fun main() {
    val bookListForParsing =
        "1. fairy tails // Alexander Sergeyevich Pushkin // 1823\n" +
                "2. Math // Kolpakov, Zheleznyak, Malov, Malova// 1823\n" +
                "3. On the Western Front // Erich Mariya Remark // 1927"
    println(parseBooks(bookListForParsing))
    println(parseBooks(bookListForParsing)[1].author.size)

    println(findTheOldest(parseBooks(bookListForParsing)))

}
