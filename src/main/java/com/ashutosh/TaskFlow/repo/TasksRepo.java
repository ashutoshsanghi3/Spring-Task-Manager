package com.ashutosh.TaskFlow.repo;


import com.ashutosh.TaskFlow.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepo extends JpaRepository<Task,Integer> {
}
