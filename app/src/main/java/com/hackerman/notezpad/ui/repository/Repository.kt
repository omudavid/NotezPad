package com.hackerman.notezpad.ui.repository

import com.hackerman.notezpad.ui.model.Note
import com.hackerman.notezpad.ui.model.ToDo

interface Repository {

    suspend fun addNote(note: Note)

    suspend fun getNotes():List<Note>

    suspend fun deleteNote(note: Note)

    suspend fun addTodo(toDo: ToDo)

    suspend fun getToDos():List<ToDo>

    suspend fun deleteTodo(toDo: ToDo)

}