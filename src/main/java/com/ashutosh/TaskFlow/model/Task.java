package com.ashutosh.TaskFlow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date dueDate;
    private boolean done;


    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true) // Define the relationship
    @JsonManagedReference
    @JsonIgnore
    private List<Note> notes;

    public Task(Task task) {
        this.name = task.getName();
        this.dueDate = new Date();
        this.done = task.isDone();
    }


}
