package lab3

import java.time.LocalDateTime

class ApplicationForNotes() : NoteInterface {
    private var noteList: MutableList<Note> = mutableListOf()
    fun addToList(note: Note) {
        noteList.add(note)
    }

    override fun getAllNotes(): List<Note> = noteList

    override fun getAllTextNotes(): List<Note.TextNote> = noteList.filterIsInstance<Note.TextNote>()

    override fun getAllTasks(): List<Note.Task> = noteList.filterIsInstance<Note.Task>()

    override fun getAllLinks(): List<Note.Link> = noteList.filterIsInstance<Note.Link>()

    override fun createTextNote(title: String, content: String): Note.TextNote =
        Note.TextNote(title, content, LocalDateTime.now())

    override fun createTask(title: String, content: String, deadline: String): Note.Task =
        Note.Task(title, content, LocalDateTime.now(), deadline)

    override fun createUrl(title: String, content: String, url: String): Note.Link =
        Note.Link(title, content, LocalDateTime.now(), url)


    override fun removeNote(note: Note) {
        noteList.remove(note)
    }

    override fun findByTitle(title: String): List<Note> = noteList.filter { it.title == title }


    override fun findByType(type: Class<Any>): List<Note> = noteList.filter {
        it.javaClass == type
    }

    override fun getSortedByTitle(): List<Note> = noteList.sortedBy { it.title }.toMutableList()


    override fun getSortedByDate(): List<Note> = noteList.sortedBy { it.date }.toMutableList()

}