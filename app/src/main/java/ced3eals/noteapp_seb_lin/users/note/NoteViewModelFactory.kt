package ced3eals.noteapp_seb_lin.users.note



import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import ced3eals.noteapp_seb_lin.database.NoteRepo


class NoteViewModelFactory(private val noteRepo: NoteRepo)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteViewModel (noteRepo) as T
    }
}