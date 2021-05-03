package com.kamal.todoapplication.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kamal.todoapplication.model.Task


@Database(entities = [Task::class],version = 1,exportSchema = false)
abstract class TasksDatabase:RoomDatabase() {

    abstract fun taskDao():TasksDao

    companion object{
        private var database: TasksDatabase?=null
        private val databaseName:String = "tasks-database"
        fun getInstance(context: Context): TasksDatabase
        {
            if(database ==null)
            {
                //create database
                database = Room.databaseBuilder(
                    context,
                    TasksDatabase::class.java,
                    databaseName
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return database!!
        }
    }
}