package com.hackerman.notezpad.ui.database.dao

import androidx.room.*
import com.hackerman.notezpad.ui.model.ToDo

@Dao
interface ToDosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addToDO(toDo: ToDo)

    @Delete
    fun deleteToDo(toDo: ToDo)

    @Query("SELECT * FROM toDos")
    fun getToDos():List<ToDo>

}