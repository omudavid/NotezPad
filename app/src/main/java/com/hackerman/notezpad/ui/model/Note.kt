package com.hackerman.notezpad.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note (
        @PrimaryKey
        val id:Int,
        var title:String ="",
        var body:String
)