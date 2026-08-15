package com.student.taskmanager.service;

import com.student.taskmanager.entity.Task;
import com.student.taskmanager.entity.User;
import com.student.taskmanager.exception.ResourceNotFoundException;
import com.student.taskmanager.repository.TaskRepository;
import com.student.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    // Helper method to get the currently logged-in user
    private User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Task createTask(Task task) {
        User currentUser = getCurrentUser();
        task.setUser(currentUser);
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        User currentUser = getCurrentUser();
        return taskRepository.findByUserId(currentUser.getId());
    }

    public Task getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with ID: " + id));

        // Security check: only the owner can see the task
        if (!task.getUser().getId().equals(getCurrentUser().getId())) {
            throw new RuntimeException("You are not allowed to access this task");
        }
        return task;
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = getTaskById(id); // this already checks ownership
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());
        task.setDueDate(updatedTask.getDueDate());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Task task = getTaskById(id); // checks ownership
        taskRepository.delete(task);
    }
}