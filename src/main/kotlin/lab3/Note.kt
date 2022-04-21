package lab3

sealed class Note(var title: String, var content: String, val date: String) {
    class TextNote(titleOfTextNote: String, contentOfTextNote: String, dateOfTextNote: String) :
        Note(titleOfTextNote, contentOfTextNote, dateOfTextNote) {
        override fun toString(): String {
            return "Title: '$title'\n" +
                    "Content: $content\n" +
                    "Date: $date"
        }
    }

    class Task(titleOfTask: String, contentOfTask: String, dateOfTask: String, var deadline: String) :
        Note(titleOfTask, contentOfTask, dateOfTask) {
        override fun toString(): String {
            return "Title: '$title'\n" +
                    "Task: $content\n" +
                    "Deadline: $deadline\n" +
                    "Date: $date"
        }
    }

    class Link(titleOfLink: String, contentOfLink: String, date_3: String, var url: String) :
        Note(titleOfLink, contentOfLink, date_3) {
        override fun toString(): String {
            return "Title: '$title'\n" +
                    "Content: '$content'\n" +
                    "URL: $url\n" +
                    "Date: $date"
        }
    }
}

