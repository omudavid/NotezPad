package com.hackerman.notezpad.ui.repository

import com.hackerman.notezpad.ui.model.Note
import com.hackerman.notezpad.ui.model.ToDo

interface Repository {

    fun addNote(note: Note)

    fun getNotes():List<Note>

    fun deleteNote(note: Note)

    fun addTodo(toDo: ToDo)

    fun getToDos():List<ToDo>

    fun deleteTodo(toDo: ToDo)

}