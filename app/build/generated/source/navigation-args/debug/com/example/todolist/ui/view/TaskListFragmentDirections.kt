package com.example.todolist.ui.view

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.todolist.R
import kotlin.Int

public class TaskListFragmentDirections private constructor() {
  private data class ActionTaskListFragmentToTaskCreateFragment(
    public val taskId: Int = 0
  ) : NavDirections {
    public override val actionId: Int = R.id.action_taskListFragment_to_taskCreateFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("taskId", this.taskId)
        return result
      }
  }

  private data class ActionTaskListFragmentToTaskDetailFragment(
    public val taskId: Int = 0
  ) : NavDirections {
    public override val actionId: Int = R.id.action_taskListFragment_to_taskDetailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("taskId", this.taskId)
        return result
      }
  }

  public companion object {
    public fun actionTaskListFragmentToTaskCreateFragment(taskId: Int = 0): NavDirections =
        ActionTaskListFragmentToTaskCreateFragment(taskId)

    public fun actionTaskListFragmentToTaskDetailFragment(taskId: Int = 0): NavDirections =
        ActionTaskListFragmentToTaskDetailFragment(taskId)
  }
}
