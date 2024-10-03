package com.ashutosh.TaskFlow.service.tasks;


import com.ashutosh.TaskFlow.model.Task;
import com.ashutosh.TaskFlow.repo.TasksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TasksServiceImpl implements TasksService {
    @Autowired
    private TasksRepo tasksRepo;

    @Override
    public List<Task> getAllTasks() {
        return tasksRepo.findAll();
    }

    @Override
    public Task getTaskById(int id) {
        Task task = tasksRepo.findById(id).orElse(null);
        if(task == null) {
            throw new TaskNotFoundException(id);
        }
        return task;
    }

    @Override
    public void createTask(Task task) {
        tasksRepo.save(new Task(task));
    }

    @Override
    public void updateTask(int id, Task task) {
        Task existingTask = getTaskById(id);
        existingTask.setName(task.getName());
        existingTask.setDueDate(new Date());
        existingTask.setDone(task.isDone());
        tasksRepo.save(existingTask);
    }

    @Override
    public void deleteTask(int id) {
        tasksRepo.delete(getTaskById(id));
    }
}
