package ced3eals.noteapp_seb_lin.utilities

import ced3eals.noteapp_seb_lin.database.FakeDatabase
import ced3eals.noteapp_seb_lin.database.NoteRepo
import ced3eals.noteapp_seb_lin.users.note.NoteViewModelFactory

// Finally a singleton which doesn't need anything passed to the constructor
object InjectUtils {

    // This will be called from QuotesActivity
    fun provideNotesViewModelFactory(): NoteViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val quoteRepository = NoteRepo.getInstance(FakeDatabase.getInstance().noteDao)
        return NoteViewModelFactory(quoteRepository)
    }
}