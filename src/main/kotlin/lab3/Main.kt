package lab3

import lab3.application.ApplicationForNotes

fun main() {
    val service = ApplicationForNotes()

    val textNote = service.createTextNote("Going to the doctor", "I need to go to the clinic and get a certificate")
    val taskNote = service.createTask("My task", "I have to go to the doctor", "2022-02-22T19:00:00")
    val linkNote = service.createUrl(
        "There may be something interesting here", "Link", "https://www.youtube.com/watch?v=oHg5SJYRHA0"
    )

    service.add(textNote)
    service.add(taskNote)
    service.add(linkNote)

    println("List of all Notes: ${service.getAllNotes()}\n")
    println("All Text Notes: ${service.getAllTextNotes()}\n")
    println("All Tasks(): ${service.getAllTasks()}\n")
    println("All Links(): ${service.getAllLinks()}\n")
    service.removeNote(textNote)
    println("List of Notes after removing Text Note: ${service.getAllNotes()}")
    println("Sorted by date: ${service.getSortedByDate()}\n")
    println(service.findByTitle("There may be something interesting here"))
}
