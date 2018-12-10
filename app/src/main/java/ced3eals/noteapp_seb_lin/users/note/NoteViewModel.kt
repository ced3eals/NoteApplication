package ced3eals.noteapp_seb_lin.users.note

import android.arch.lifecycle.ViewModel
import ced3eals.noteapp_seb_lin.database.Note
import ced3eals.noteapp_seb_lin.database.NoteRepo

// QuoteRepository dependency will again be passed in the
// constructor using dependency injection
class NoteViewModel(private val noteRepo: NoteRepo)
    : ViewModel() {

    fun getNote() = noteRepo.getNote()

    fun addNote(note: Note) = noteRepo.addNote(note)
}