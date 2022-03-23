package lab1

import java.lang.Integer.max
import kotlin.math.min

fun findTheOldest(bookList: List<Book>): List<Book> { //search for the oldest book
    var earliestYear: Int = Int.MAX_VALUE
    bookList.forEach {
        earliestYear = min(earliestYear, it.year)
    }
    return bookList.filter { it.year == earliestYear }
}

fun findTheNewest(bookList: List<Book>): List<Book> { //search for the newest book
    var oldestYear: Int = Int.MIN_VALUE
    bookList.forEach {
        oldestYear = max(oldestYear, it.year)
    }
    return bookList.filter { it.year == oldestYear }
}

fun findTheLongest(bookList: List<Book>): List<Book> { //search for book with the longest title
    val longestTitle = bookList.maxOf { it.title.length }
    return bookList.filter { it.title.length == longestTitle }
}

fun findTheShortest(bookList: List<Book>): List<Book> { //search for the book with the shortest title
    val shortestTitle = bookList.minOf { it.title.length }
    return bookList.filter { it.title.length == shortestTitle }
}