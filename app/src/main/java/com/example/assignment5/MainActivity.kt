package com.example.assignment5

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var editTextTask: EditText
    private lateinit var buttonAdd: Button
    private lateinit var recyclerViewTasks: RecyclerView
    private lateinit var taskList: MutableList<Task>
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTask = findViewById(R.id.editText)
        buttonAdd = findViewById(R.id.addButton)
        recyclerViewTasks = findViewById(R.id.recyclerView)

        taskList = mutableListOf()
        taskAdapter = TaskAdapter(taskList)

        recyclerViewTasks.layoutManager = LinearLayoutManager(this)
        recyclerViewTasks.adapter = taskAdapter

        buttonAdd.setOnClickListener {
            recyclerViewTasks.visibility = View.VISIBLE

            val taskDescription = editTextTask.text.toString()
            if (taskDescription.isNotEmpty()) {
                val newTask = Task(taskDescription)
                taskList.add(newTask)
                taskAdapter.notifyDataSetChanged()
                editTextTask.text.clear()

            }
        }
    }
}
