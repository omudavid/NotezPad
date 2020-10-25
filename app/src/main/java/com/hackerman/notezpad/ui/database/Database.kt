package com.hackerman.notezpad.ui.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hackerman.notezpad.ui.database.dao.NotesDao
import com.hackerman.notezpad.ui.database.dao.ToDosDao
import com.hackerman.notezpad.ui.model.Note
import com.hackerman.notezpad.ui.model.ToDo

const val DATABASE_VERSION = 1

@Database(entities = [Note::class,ToDo::class],
        version = DATABASE_VERSION
)

abstract class NotezPadDatabase :RoomDatabase() {
    companion object{
        private val DATABASE_NAME = "NotezPadDatabase"

        fun buildDatabase(context: Context):NotezPadDatabase{
            return Room.databaseBuilder(context,NotezPadDatabase::class.java, DATABASE_NAME).build()
        }
    }

    abstract fun toDosDao():ToDosDao

    abstract fun NotesDao():NotesDao
}