package com.example.todolist.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todolist.MainActivity
import com.example.todolist.data.model.Task
import com.example.todolist.data.repository.TaskRepository
import com.example.todolist.databinding.FragmentTaskCreateBinding
import com.example.todolist.ui.viewmodel.TaskViewModel
import com.example.todolist.ui.viewmodel.TaskViewModelFactory

class TaskCreateFragment : Fragment() {

    private var _binding: FragmentTaskCreateBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TaskViewModel
    private val args: TaskCreateFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskCreateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskDao = (requireActivity() as MainActivity).database.taskDao()
        val repository = TaskRepository(taskDao)
        val factory = TaskViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[TaskViewModel::class.java]

        // Fetch Task using taskId
        val taskId = args.taskId
        if (taskId != 0) {
            viewModel.getTaskById(taskId).observe(viewLifecycleOwner) { task ->
                task?.let {
                    // Pre-fill fields if editing
                    binding.editTextTitle.setText(task.title)
                    binding.editTextDescription.setText(task.description)
                }
            }
        }

        binding.buttonSave.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val description = binding.editTextDescription.text.toString()

            val task = if (taskId == 0) {
                Task(title = title, description = description)
            } else {
                Task(id = taskId, title = title, description = description)
            }

            if (taskId == 0) {
                viewModel.insertTask(task)
            } else {
                viewModel.updateTask(task)
            }

            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}