package com.example.todolist.data.repository

import com.example.todolist.data.TaskDao
import com.example.todolist.data.model.Task

class TaskRepository(private val taskDao: TaskDao) {

    suspend fun insert(task: Task) {
        taskDao.insert(task)
    }

    suspend fun update(task: Task) {
        taskDao.update(task)
    }

    suspend fun getAllTasks(): List<Task> {
        return taskDao.getAllTasks()
    }

    suspend fun getTaskById(taskId: Int): Task {
        return taskDao.getTaskById(taskId)
    }

    suspend fun delete(taskId: Int) {
        taskDao.delete(taskId)
    }
}
