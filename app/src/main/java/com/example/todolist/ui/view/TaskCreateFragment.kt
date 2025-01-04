package com.example.todolist.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todolist.R
import com.example.todolist.data.model.Task
import com.example.todolist.ui.viewmodel.TaskViewModel

class TaskCreateFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()
    private val args: TaskCreateFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task_create, container, false)

        val editTitle: EditText = view.findViewById(R.id.editTitle)
        val editDescription: EditText = view.findViewById(R.id.editDescription)
        val saveButton: Button = view.findViewById(R.id.saveButton)

        // If editing an existing task, populate the fields
        args.task?.let { task ->
            editTitle.setText(task.title)
            editDescription.setText(task.description)
        }

        saveButton.setOnClickListener {
            val title = editTitle.text.toString()
            val description = editDescription.text.toString()
            val task = Task(id = args.taskId, title = title, description = description)
            viewModel.insertTask(task)

            // Navigate back to the task list
            findNavController().navigate(R.id.action_taskCreateFragment_to_taskListFragment)
        }

        return view
    }
}