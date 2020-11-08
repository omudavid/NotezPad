package com.hackerman.notezpad.ui.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hackerman.notezpad.ui.database.NotezPadDatabase
import com.hackerman.notezpad.ui.model.Note
import com.hackerman.notezpad.ui.repository.RepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class NoteFragmentViewModel(application: Application) :ViewModel(), CoroutineScope {
    var _note: MutableLiveData<Note> = MutableLiveData()
    val note:LiveData<Note> get() = _note

    var repository: RepositoryImpl

    init {
        val database = NotezPadDatabase.buildDatabase(application)
        repository = RepositoryImpl(database.toDosDao(),database.notesDao())
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    fun addNote(note:Note){
        launch {
            withContext(Dispatchers.IO){
                repository.addNote(note)
            }
        }
    }

    fun getNote(){
        launch {
            withContext(Dispatchers.IO){
                repository.getNotes()
            }
        }
    }
}