package com.example.todolist.data.repository

import androidx.lifecycle.LiveData
import com.example.todolist.data.TaskDao
import com.example.todolist.data.model.Task

class TaskRepository(private val taskDao: TaskDao) {

    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks()

    suspend fun insertTask(task: Task) {
        taskDao.insertTask(task)
    }

    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }
}
