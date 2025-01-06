package com.example.todolist.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/todolist/ui/viewmodel/TaskViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/todolist/data/repository/TaskRepository;", "(Lcom/example/todolist/data/repository/TaskRepository;)V", "allTasks", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/todolist/data/model/Task;", "deleteTask", "", "task", "getTaskById", "id", "", "insertTask", "updateTask", "app_debug"})
public final class TaskViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.todolist.data.repository.TaskRepository repository = null;
    
    public TaskViewModel(@org.jetbrains.annotations.NotNull()
    com.example.todolist.data.repository.TaskRepository repository) {
        super();
    }
    
    public final void insertTask(@org.jetbrains.annotations.NotNull()
    com.example.todolist.data.model.Task task) {
    }
    
    public final void updateTask(@org.jetbrains.annotations.NotNull()
    com.example.todolist.data.model.Task task) {
    }
    
    public final void deleteTask(@org.jetbrains.annotations.NotNull()
    com.example.todolist.data.model.Task task) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.todolist.data.model.Task>> allTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.todolist.data.model.Task> getTaskById(int id) {
        return null;
    }
}