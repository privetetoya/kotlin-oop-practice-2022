package lab1

fun main() {
    val bookListForParsing =
        "1. Война и миръ // Лев Николаевич Толстой // 1865\n" +
                "2. Двенадцать стульев // Ильф И., Петров Е.// 1927\n" +
                "3. Im Westen nichts Neues // Erich Maria Remarque // 1927"

    val bookList = parseBooks(bookListForParsing)
    println(bookList)

    println("List of the oldest books: ${findTheOldest(bookList)}")
    println("List of the newest books: ${findTheNewest(bookList)}")
    println("List of the longest books: ${findTheLongest(bookList)}")
    println("List of the shortest books: ${findTheShortest(bookList)}")
}