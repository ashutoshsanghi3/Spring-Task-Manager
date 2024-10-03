package com.ashutosh.TaskFlow.controller;


import com.ashutosh.TaskFlow.dto.ErrorResponse;
import com.ashutosh.TaskFlow.dto.SuccessResponse;
import com.ashutosh.TaskFlow.dto.TasksResponse;
import com.ashutosh.TaskFlow.model.Task;
import com.ashutosh.TaskFlow.service.notes.NotesService;
import com.ashutosh.TaskFlow.service.tasks.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TasksController {
    @Autowired
    private TasksService tasksService;
    @Autowired
    private NotesService notesService;

    @GetMapping("")
    public ResponseEntity<TasksResponse> getAllTasks() {
        List<Task> tasks= tasksService.getAllTasks();
        return ResponseEntity.ok(new TasksResponse(tasks.size(),tasks));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        Task task = tasksService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping("")
    public ResponseEntity<SuccessResponse> createTask(@RequestBody Task task) {
        tasksService.createTask(task);
        return new ResponseEntity<>(new SuccessResponse("Task created successfully"),HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SuccessResponse> updateTask(@PathVariable int id, @RequestBody Task task) {
        tasksService.updateTask(id, task);
        return ResponseEntity.accepted().body(new SuccessResponse("Task "+ id + " updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteTask(@PathVariable int id) {
        notesService.deleteNotes(id);
        tasksService.deleteTask(id);
        return ResponseEntity.accepted().body(new SuccessResponse("Task "+ id + " deleted successfully"));
    }

    @ExceptionHandler(TasksService.TaskNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception){
        return new ResponseEntity<>(
                new ErrorResponse(exception.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }


}
