package com.example.todolist.ui.view

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todolist.data.TaskDatabase
import com.example.todolist.data.repository.TaskRepository
import com.example.todolist.databinding.FragmentTaskDetailBinding
import com.example.todolist.ui.viewmodel.TaskViewModel
import com.example.todolist.ui.viewmodel.TaskViewModelFactory

class TaskDetailFragment : Fragment() {

    private var _binding: FragmentTaskDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TaskViewModel
    private val args: TaskDetailFragmentArgs by navArgs() // TaskId from navigation arguments

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        val dao = TaskDatabase.getDatabase(requireContext()).taskDao()
        val repository = TaskRepository(dao)
        val factory = TaskViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(TaskViewModel::class.java)

        // Get taskId from args
        val taskId = args.taskId

        // Observe the task by taskId
        viewModel.getTaskById(taskId).observe(viewLifecycleOwner) { task ->
            task?.let {
                // Update UI with task details
                binding.textViewTitle.text = Editable.Factory.getInstance().newEditable(task.title)
                binding.textViewDescription.text = Editable.Factory.getInstance().newEditable(task.description)

                // Navigate to edit fragment with taskId
                binding.buttonEdit.setOnClickListener {
                    val action = TaskDetailFragmentDirections
                        .actionTaskDetailFragmentToTaskCreateFragment(taskId = task.id)
                    findNavController().navigate(action)
                }

                // Delete the task and navigate back
                binding.buttonDelete.setOnClickListener {
                    viewModel.deleteTask(task)
                    findNavController().navigateUp()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}