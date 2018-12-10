package ced3eals.noteapp_seb_lin.database

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

class FakeNote {
    // A fake database table
    private val noteList = mutableListOf<Note>()
    // MutableLiveData is from the Architecture Components Library
    // LiveData can be observed for changes
    private val note = MutableLiveData<List<Note>>()

    init {
        // Immediately connect the now empty quoteList
        // to the MutableLiveData which can be observed
        note.value = noteList
    }

    fun addNote(notes: Note) {
        noteList.add(notes)
        // After adding a quote to the "database",
        // update the value of MutableLiveData
        // which will notify its active observers
        note.value = noteList
    }

    // Casting MutableLiveData to LiveData because its value
    // shouldn't be changed from other classes
    fun getNote() = note as LiveData<List<Note>>
}