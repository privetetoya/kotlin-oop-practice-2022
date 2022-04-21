package lab3

import java.time.LocalDateTime

sealed class Note(var title: String, var content: String, val date: LocalDateTime) {
    class TextNote(titleOfTextNote: String, contentOfTextNote: String, dateOfTextNote: LocalDateTime) :
        Note(titleOfTextNote, contentOfTextNote, dateOfTextNote) {
        override fun toString(): String {
            return "Title: '$title'\n" +
                    "Task: $content\n" +
                    "Deadline: $date\n" +
                    "Date: $date"
        }
    }

    class Task(titleOfTask: String, contentOfTask: String, dateOfTask: LocalDateTime, var deadline: String) :
        Note(titleOfTask, contentOfTask, dateOfTask) {
        override fun toString(): String {
            return "Title: '$title'\n" +
                    "Task: $content\n" +
                    "Deadline: $deadline\n" +
                    "Date: $date"
        }
    }

    class Link(title_3: String, content_3: String, date_3: LocalDateTime, var url: String) :
        Note(title_3, content_3, date_3) {
        override fun toString(): String {
            return "Title: '$title'\n" +
                    "Content: '$content'\n" +
                    "URL: $url\n" +
                    "Date: $date"
        }
    }
}

