package com.student.taskmanager.repository;

import com.student.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // This method is required
    List<Task> findByUserId(Integer userId);
}