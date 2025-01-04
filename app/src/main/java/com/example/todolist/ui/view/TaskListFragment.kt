package com.example.todolist.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.data.TaskDatabase
import com.example.todolist.data.repository.TaskRepository
import com.example.todolist.databinding.FragmentTaskListBinding
import com.example.todolist.ui.viewmodel.TaskViewModel
import com.example.todolist.ui.viewmodel.TaskViewModelFactory

class TaskListFragment : Fragment() {

    private var _binding: FragmentTaskListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dao = TaskDatabase.getDatabase(requireContext()).taskDao()
        val repository = TaskRepository(dao)
        val factory = TaskViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(TaskViewModel::class.java)

        val adapter = TaskListAdapter { task ->
            // On click → navigate to task detail
            val action = TaskListFragmentDirections.actionTaskListFragmentToTaskCreateFragment(taskId = task.id, task = task)
            findNavController().navigate(action)

        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        // Observe the tasks from the ViewModel
        viewModel.allTasks.observe(viewLifecycleOwner) { tasks ->
            adapter.submitList(tasks) // Submit the tasks to the adapter
        }

        // Floating Action Button to add a new task
        binding.fabAddTask.setOnClickListener {
            // Navigate to TaskCreateFragment to create a new task
            val action = TaskListFragmentDirections.actionTaskListFragmentToTaskCreateFragment(taskId = 0, task = null)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
