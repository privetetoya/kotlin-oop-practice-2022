package lab3.NoteAndInterface

import java.time.LocalDateTime
sealed class Note(open var title: String, open var content: String, open val date: LocalDateTime) {
    data class TextNote(override var title: String, override var content: String, override var date: LocalDateTime) : Note(title, content, date) {
        override fun toString(): String {
            return "Title: '$title'\nContent: '$content'\n Date: $date)"
        }
    }

    data class Task(override var title: String, override var content: String, override var date: LocalDateTime, var deadline: String) :
        Note(title, content, date) {
        override fun toString(): String {
            return "Title: '$title'\n Content: '$content'\n Date: '$date'\n Deadline: '$deadline'"
        }
    }

    data class Link(override var title: String, override var content: String, override var date: LocalDateTime, var url: String) :
        Note(title, content, date) {
        override fun toString(): String {
            return "Title: '$title'\n Content: '$content'\n Date: '$date'\n Link: '$url'"
        }
    }
}