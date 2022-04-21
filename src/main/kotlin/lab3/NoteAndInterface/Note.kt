package lab3.NoteAndInterface

import java.time.LocalDateTime

sealed class Note(var title: String, var content: String, val date: LocalDateTime) {
    class TextNote(titleOfTextNote: String, contentOfTextNote: String, dateOfTextNote: LocalDateTime) :
        Note(titleOfTextNote, contentOfTextNote, dateOfTextNote) {
        override fun toString(): String {
            return "Title: '$title'\nContent: $content\nDate: $date"
        }
    }

    class Task(titleOfTask: String, contentOfTask: String, dateOfTask: LocalDateTime, private var deadline: String) :
        Note(titleOfTask, contentOfTask, dateOfTask) {
        override fun toString(): String {
            return "Title: '$title'\nTask: $content\nDeadline: $deadline\nDate: $date"
        }
    }

    class Link(titleOfLink: String, contentOfLink: String, dateOfLink: LocalDateTime, private var url: String) :
        Note(titleOfLink, contentOfLink, dateOfLink) {
        override fun toString(): String {
            return "Title: '$title'\nContent: '$content'\nURL: $url\nDate: $date"
        }
    }
}