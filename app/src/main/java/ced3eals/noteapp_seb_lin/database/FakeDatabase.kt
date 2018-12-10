package ced3eals.noteapp_seb_lin.database

class FakeDatabase private constructor() {

    var noteDao = FakeNote()
        private set

    companion object {

        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() =

                instance ?: synchronized(this) {
                    // If it's still not instantiated, finally create an object
                    // also set the "instance" property to be the currently created one
                    instance ?: FakeDatabase().also { instance = it }
                }
    }
}