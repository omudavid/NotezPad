package com.hackerman.notezpad.ui.repository

import com.hackerman.notezpad.ui.database.dao.NotesDao
import com.hackerman.notezpad.ui.database.dao.ToDosDao
import com.hackerman.notezpad.ui.model.Note
import com.hackerman.notezpad.ui.model.ToDo

class RepositoryImpl (private val toDosDao: ToDosDao,
                      private val notesDao: NotesDao):Repository {

    override fun addNote(note: Note) = notesDao.addNote(note)

    override fun getNotes(): List<Note> = notesDao.getNotes()

    override fun deleteNote(note: Note) = notesDao.deleteNote(note)

    override fun addTodo(toDo: ToDo) = toDosDao.addToDO(toDo)

    override fun getToDos(): List<ToDo> = toDosDao.getToDos()

    override fun deleteTodo(toDo: ToDo) = toDosDao.deleteToDo(toDo)

}