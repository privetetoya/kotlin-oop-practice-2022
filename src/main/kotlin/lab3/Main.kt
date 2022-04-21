package lab3

fun main()
{
    val service = ApplicationForNotes()
    val textNote = service.createTextNote("Going to the doctor", "I need to go to the clinic and get a certificate", )
    val taskNote = service.createTask("Today task", "go to class", "19.02.2018")
    val linkNote = service.createUrl("github link", "Our link", "https://github.com/C0ffee-Hunter/kotlin-oop-practice-2022/tree/master/src/main/kotlin")

    service.addToList(linkNote)
    service.addToList(textNote)
    service.addToList(taskNote)

    println(service.getAllNotes())
    println(service.findByTitle("github link"))
    println(service.getSortedByDate())
}