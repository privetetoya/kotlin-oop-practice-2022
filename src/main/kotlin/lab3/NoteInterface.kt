package lab3

interface NoteInterface {
    fun getAllNotes(): List<Note>
    fun getAllTextNotes(): List<Note.TextNote>
    fun getAllTasks(): List<Note.Task>
    fun getAllLinks(): List<Note.Link>
    fun createTextNote(title: String, content: String): Note.TextNote
    fun createTask(title: String, content: String, deadline: String): Note.Task
    fun createUrl(title: String, content: String, url: String): Note.Link
    fun removeNote(note: Note)
    fun findByTitle(title: String): List<Note>
    fun findByType(type: Class<Any>): List<Note>
    fun getSortedByTitle(): List<Note>
    fun getSortedByDate(): List<Note>
}