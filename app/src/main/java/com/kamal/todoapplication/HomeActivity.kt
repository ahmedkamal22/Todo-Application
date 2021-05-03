package com.kamal.todoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        add_task.setOnClickListener {
            goToAddTask()
        }
    }

    private fun goToAddTask() {
        val intent = Intent(this,AddTaskActivity::class.java)
        startActivity(intent)
        finish()
    }
}