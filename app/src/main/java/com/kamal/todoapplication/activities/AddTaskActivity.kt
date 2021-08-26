package com.kamal.todoapplication.activities

import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.islami.base.BaseActivity
import com.kamal.todoapplication.R
import com.kamal.todoapplication.database.dao.TasksDatabase
import com.kamal.todoapplication.model.Task
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        removeError()
        save.setOnClickListener {
            addTask()
        }
    }

    private fun addTask() {
        if(!Valid()) return
        val title = layout_title.editText?.text.toString()
        val description = layout_description.editText?.text.toString()
        val task = Task(title = title,description = description,isCompeleted = completed.isChecked)
        TasksDatabase.getInstance(applicationContext)
            .taskDao().addTask(task)
        showDialig(title = "Done!!",message = "Congratulation Task Added Successfully",
                posActionName = "Yes",
            posAction = DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
                finish()
            })
    }

   private fun removeError()
    {
        layout_title.editText?.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                layout_title.error = null
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
        layout_description.editText?.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                layout_description.error = null
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }
    private fun Valid(): Boolean {
        var valid = true
        if(layout_title.editText?.text.toString().isBlank())
        {
            valid = false
            layout_title.error = "Please write title here!"
        }
        if(layout_description.editText?.text.toString().isBlank())
        {
            valid = false
            layout_description.error = "Please write description here!"
        }
        return valid
    }
}