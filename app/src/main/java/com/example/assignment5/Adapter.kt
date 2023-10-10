package com.example.assignment5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private val taskList: MutableList<Task>) : RecyclerView.Adapter<TaskAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_details, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = taskList[position]
        holder.taskDescription.text = task.description
        holder.checkBox.isChecked = task.isCompleted

        holder.checkBox.setOnClickListener {
            task.isCompleted = holder.checkBox.isChecked
        }

        holder.deleteTaskButton.setOnClickListener {
            taskList.removeAt(holder.adapterPosition)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox: CheckBox = itemView.findViewById(R.id.checkbox)
        val taskDescription: TextView = itemView.findViewById(R.id.taskDescription)
        val deleteTaskButton: Button = itemView.findViewById(R.id.deleteButton)
    }
}