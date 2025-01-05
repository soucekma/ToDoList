package com.example.todolist.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.data.model.Task
import com.example.todolist.data.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    fun insertTask(task: Task) {
        viewModelScope.launch {
            repository.insert(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.update(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.delete(task.id)
        }
    }
    fun allTasks(): LiveData<List<Task>> {
        return repository.getAllTasks()
    }
    fun getTaskById(id: Int): LiveData<Task> {
           return repository.getTaskById(id)
    }
}
