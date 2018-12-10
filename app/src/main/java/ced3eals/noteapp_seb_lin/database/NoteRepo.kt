package ced3eals.noteapp_seb_lin.database

// FakeQuoteDao must be passed in - it is a dependency
// You could also instantiate the DAO right inside the class without all the fuss, right?
// No. This would break testability - you need to be able to pass a mock version of a DAO
// to the repository (e.g. one that upon calling getQuotes() returns a dummy list of quotes for testing)
// This is the core idea behind DEPENDENCY INJECTION - making things completely modular and independent.
class NoteRepo private constructor(private val noteDao: FakeNote) {

    // This may seem redundant.
    // Imagine a code which also updates and checks the backend.
    fun addNote(note: Note) {
        noteDao.addNote(note)
    }

    fun getNote() = noteDao.getNote()

    companion object {
        // Singleton instantiation you already know and love
        @Volatile private var instance: NoteRepo? = null

        fun getInstance(noteDao: FakeNote) =
                instance ?: synchronized(this) {
                    instance ?: NoteRepo(noteDao).also { instance = it }
                }
    }
}