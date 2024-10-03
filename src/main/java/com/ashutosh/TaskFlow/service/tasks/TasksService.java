package com.ashutosh.TaskFlow.service.tasks;


import com.ashutosh.TaskFlow.model.Task;

import java.util.List;

public interface TasksService {
    List<Task> getAllTasks();

    Task getTaskById(int id);

    void createTask(Task task);

    void updateTask(int id, Task task);

    void deleteTask(int id);
    class TaskNotFoundException extends IllegalArgumentException {
        public TaskNotFoundException(int id){
            super("Could not find task with id: " + id);
        }
    }
}
