package com.kamal.todoapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kamal.todoapplication.R
import com.kamal.todoapplication.model.Task
import kotlinx.android.synthetic.main.layout_task.view.*

class TasksAdapater(var tasks:List<Task>) :RecyclerView.Adapter<TasksAdapater.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_task,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks.get(position)
        holder.tilte.setText(task.title)
        holder.completed.isChecked = task.isCompeleted?:false
    }

    fun changeData(tasks: List<Task>) {
        this.tasks = tasks
        notifyDataSetChanged()
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        val tilte:TextView = itemView.task_title
        val completed:CheckBox = itemView.task_completed
    }
}