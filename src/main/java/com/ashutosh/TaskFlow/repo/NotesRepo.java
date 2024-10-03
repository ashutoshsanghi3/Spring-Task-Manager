package com.ashutosh.TaskFlow.repo;


import com.ashutosh.TaskFlow.model.Note;
import com.ashutosh.TaskFlow.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepo extends JpaRepository<Note,Integer> {

    @Query("SELECT n FROM Note n WHERE n.task = :task")
    List<Note> findByTask(Task task);

    @Query("SELECT n FROM Note n WHERE n.task = :task AND n.id = :id")
    Note findByIdAndTask(int id, Task task);

}
