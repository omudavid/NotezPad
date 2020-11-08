package com.hackerman.notezpad.ui.repository

import com.hackerman.notezpad.ui.database.dao.NotesDao
import com.hackerman.notezpad.ui.database.dao.ToDosDao
import com.hackerman.notezpad.ui.model.Note
import com.hackerman.notezpad.ui.model.ToDo

class RepositoryImpl (private val toDosDao: ToDosDao,
                      private val notesDao: NotesDao):Repository {

    override suspend fun addNote(note: Note) = notesDao.addNote(note)

    override suspend fun getNotes(): List<Note> = notesDao.getNotes()

    override suspend fun deleteNote(note: Note) = notesDao.deleteNote(note)

    override suspend fun addTodo(toDo: ToDo) = toDosDao.addToDO(toDo)

    override suspend fun getToDos(): List<ToDo> = toDosDao.getToDos()

    override suspend fun deleteTodo(toDo: ToDo) = toDosDao.deleteToDo(toDo)

}