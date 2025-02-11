package com.walter.mordomo.service;

import com.walter.mordomo.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    Optional<Task> getTasksByUserId(Long userId);
    Task updateTask(Long id, Task taskDetails);
    void deleteTask(Long id);
}
