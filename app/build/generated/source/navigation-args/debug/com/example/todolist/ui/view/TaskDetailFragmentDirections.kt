package com.example.todolist.ui.view

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.todolist.R
import kotlin.Int

public class TaskDetailFragmentDirections private constructor() {
  private data class ActionTaskDetailFragmentToTaskCreateFragment(
    public val taskId: Int = 0
  ) : NavDirections {
    public override val actionId: Int = R.id.action_taskDetailFragment_to_taskCreateFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("taskId", this.taskId)
        return result
      }
  }

  public companion object {
    public fun actionTaskDetailFragmentToTaskCreateFragment(taskId: Int = 0): NavDirections =
        ActionTaskDetailFragmentToTaskCreateFragment(taskId)
  }
}
