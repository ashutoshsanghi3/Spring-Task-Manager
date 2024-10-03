package com.ashutosh.TaskFlow.dto;


import com.ashutosh.TaskFlow.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TasksResponse {
    private int taskcount;
    private List<Task> task;
}
