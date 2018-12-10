package ced3eals.noteapp_seb_lin.users.note

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import ced3eals.noteapp_seb_lin.R
import ced3eals.noteapp_seb_lin.database.Note
import ced3eals.noteapp_seb_lin.utilities.InjectUtils
import kotlinx.android.synthetic.main.activity_note_app.*
import java.lang.reflect.Array.get
import java.util.Observer
import android.widget.EditText
//import ced3eals.noteapp_seb_lin.good_database.DatabaseHelper




class NoteApp : AppCompatActivity() {

    private val TAG = "MainActivity"

   // var mDatabaseHelper: DatabaseHelper? = null
    private val btnAdd: Button? = null
    private val btnViewData: Button? = null
    private val editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_app)
        initializeUi()
    }


    private fun initializeUi() {
        // Get the QuotesViewModelFactory with all of it's dependencies constructed
        val factory = InjectUtils.provideNotesViewModelFactory()
        // Use ViewModelProviders class to create / get already created QuotesViewModel
        // for this view (activity)
        val viewModel = ViewModelProviders.of(this, factory).get(NoteViewModel::class.java)

        // Observing LiveData from the QuotesViewModel which in turn observes
        // LiveData from the repository, which observes LiveData from the DAO ☺
        viewModel.getNote().observe (this, android.arch.lifecycle.Observer { note ->
            val stringBuilder = StringBuilder()
            if (note != null) {
                note.forEach { note -> stringBuilder.append("$note\n\n")}
            }
            textView_note.text = stringBuilder.toString()
        })

        // When button is clicked, instantiate a Quote and add it to DB through the ViewModel
        button_add_note.setOnClickListener {
            val notes = Note(editText_note.text.toString(), editText_author.text.toString())
            viewModel.addNote(notes)
            editText_note.setText("")
            editText_author.setText("")
        }
    }

}
