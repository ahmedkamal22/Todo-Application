package com.kamal.todoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kamal.todoapplication.adapter.TasksAdapater
import com.kamal.todoapplication.database.dao.TasksDatabase
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    lateinit var tasksAdapater: TasksAdapater
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        add_task.setOnClickListener {
            goToAddTask()
        }
    }
    override fun onStart() {
        super.onStart()
        recyclerViewComponents()
        val tasks = TasksDatabase.getInstance(applicationContext).taskDao().getAllTasks()
        tasksAdapater.changeData(tasks)
    }
    private fun recyclerViewComponents() {
        tasksAdapater = TasksAdapater(listOf())
        task_recycler_view.adapter = tasksAdapater
    }


    private fun goToAddTask() {
        val intent = Intent(this,AddTaskActivity::class.java)
        startActivity(intent)
    }
}