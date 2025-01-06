package com.example.todolist.ui.view

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class TaskCreateFragmentArgs(
  public val taskId: Int = 0
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("taskId", this.taskId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("taskId", this.taskId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): TaskCreateFragmentArgs {
      bundle.setClassLoader(TaskCreateFragmentArgs::class.java.classLoader)
      val __taskId : Int
      if (bundle.containsKey("taskId")) {
        __taskId = bundle.getInt("taskId")
      } else {
        __taskId = 0
      }
      return TaskCreateFragmentArgs(__taskId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): TaskCreateFragmentArgs {
      val __taskId : Int?
      if (savedStateHandle.contains("taskId")) {
        __taskId = savedStateHandle["taskId"]
        if (__taskId == null) {
          throw IllegalArgumentException("Argument \"taskId\" of type integer does not support null values")
        }
      } else {
        __taskId = 0
      }
      return TaskCreateFragmentArgs(__taskId)
    }
  }
}
