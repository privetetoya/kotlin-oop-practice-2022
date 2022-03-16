package lab1

import java.lang.Integer.max
import kotlin.math.min

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

        if (listOfBookLines[i].substringBefore(separator).trim().isNotEmpty()) { //take authors between separator and comma
            while (listOfBookLines[i].contains(comma)) {
                authors.add(listOfBookLines[i].substringBefore(comma).trim())
                listOfBookLines[i] = listOfBookLines[i].substringAfter(comma)

            }
            authors.add(listOfBookLines[i].substringBefore(separator).trim()) //take author between last comma and separator
            listOfBookLines[i] = listOfBookLines[i].substringAfter(separator)
        }

        val year: Int = listOfBookLines[i].filter { it.isDigit() }.toInt() // take year of book
        bookList.add(Book(title, authors, year))
    }
    return bookList
}


fun findTheOldest(bookList: List<Book>): List<Book> { //search for the oldest book
    var earliestYear: Int = Int.MAX_VALUE
    bookList.forEach {
        earliestYear = min(earliestYear, it.year)
    }
    return bookList.filter { it.year == earliestYear }
}

fun findTheNewest(bookList: List<Book>): List<Book> { //search for the newest book
    var oldestYear : Int = Int.MIN_VALUE
    bookList.forEach {
        oldestYear = max(oldestYear, it.year)
    }
    return bookList.filter { it.year == oldestYear }
}

fun findTheLongest(bookList: List<Book>): List<Book>  { //search for book with the longest title
    val longestTitle = bookList.maxOf {it.title.length}
    return bookList.filter {it.title.length == longestTitle}
}

fun findTheShortest(bookList: List<Book>): List<Book>  { //search for the book with the shortest title
    val shortestTitle = bookList.minOf {it.title.length}
    return bookList.filter {it.title.length == shortestTitle}
}


fun main() {
    val bookListForParsing =
                "1. Война и миръ // Лев Николаевич Толстой // 1865\n" +
                "2. Двенадцать стульев // Ильф И., Петров Е.// 1927\n" +
                "3. Im Westen nichts Neues // Erich Maria Remarque // 1927"
    println(parseBooks(bookListForParsing))

    println(findTheNewest(parseBooks(bookListForParsing)))
    println(findTheOldest(parseBooks(bookListForParsing)))
    println(findTheLongest(parseBooks(bookListForParsing)))
    println(findTheShortest(parseBooks(bookListForParsing)))

}
