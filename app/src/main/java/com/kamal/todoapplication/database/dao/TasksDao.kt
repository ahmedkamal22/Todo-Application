package com.kamal.todoapplication.database.dao

import androidx.room.*
import com.kamal.todoapplication.model.Task

@Dao
interface TasksDao {

    @Insert
    fun addTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Update
    fun updateTask(task: Task)

    @Query("select * from Task")
    fun getAllTasks():List<Task>

    @Query("select * from Task where title like :word or description like :word")
    fun searchForTask(word:String):List<Task>
}