package ced3eals.noteapp_seb_lin.database

data class Note(val noteText: String,
                val author: String) {
    override fun toString(): String {
        return "$noteText - $author"
    }
}