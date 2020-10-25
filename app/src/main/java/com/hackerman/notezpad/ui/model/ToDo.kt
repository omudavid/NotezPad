package com.hackerman.notezpad.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toDos")
data class ToDo(
        var todo:String,
        @PrimaryKey
        val id:Int,
        var complete:Boolean = false
)