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

class NotesFragmentViewModel(application: Application): ViewModel(),CoroutineScope
{
    var _list : MutableLiveData<List<Note>> = MutableLiveData()
    val list : LiveData<List<Note>> get() = _list

    private var repository : RepositoryImpl

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    init {
        val database = NotezPadDatabase.buildDatabase(application)
        repository = RepositoryImpl(database.toDosDao(),database.notesDao())
    }

    fun getNotes(){
        launch {
            withContext(Dispatchers.IO){
               _list.postValue(repository.getNotes())
            }
        }

    }


}