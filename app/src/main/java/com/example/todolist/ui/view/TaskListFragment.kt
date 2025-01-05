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
import com.example.todolist.data.model.Task
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

        val adapter = TaskListAdapter { task: Task ->
            val action = TaskListFragmentDirections.actionTaskListFragmentToTaskDetailFragment(task.id)
            findNavController().navigate(action)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.allTasks().observe(viewLifecycleOwner, { tasks: List<Task> ->
            adapter.submitList(tasks)
        })

        binding.fabAddTask.setOnClickListener {
            val action = TaskListFragmentDirections.actionTaskListFragmentToTaskCreateFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}