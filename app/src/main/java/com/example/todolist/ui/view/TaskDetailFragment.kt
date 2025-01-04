package com.example.todolist.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todolist.MainActivity
import com.example.todolist.R
import com.example.todolist.databinding.FragmentTaskDetailBinding
import com.example.todolist.ui.viewmodel.TaskViewModel

class TaskDetailFragment : Fragment() {

    private var _binding: FragmentTaskDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TaskViewModel
    private val args: TaskDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel

        // Display task title and description
        val task = args.task
        binding.textViewTitle.text = task.title
        binding.textViewDescription.text = task.description

        // Edit button click
        binding.buttonEdit.setOnClickListener {
            val action = TaskDetailFragmentDirections.actionTaskDetailFragmentToTaskCreateFragment(task.id)
            findNavController().navigate(action)
        }

        // Delete button click
        binding.buttonDelete.setOnClickListener {
            viewModel.deleteTask(task)
            findNavController().navigateUp() // Navigate back to TaskListFragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
