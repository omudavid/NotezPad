package com.hackerman.notezpad.ui.database.dao

import androidx.room.*
import com.hackerman.notezpad.ui.model.Note

@Dao
interface NotesDao {

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    fun addNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("SELECT * FROM notes")
    fun getNotes():List<Note>
}