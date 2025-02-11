package com.walter.mordomo.service.impl;

import com.walter.mordomo.model.Task;
import com.walter.mordomo.repository.TaskRepository;
import com.walter.mordomo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
    public class TaskServiceImpl implements TaskService {

        @Autowired
        private TaskRepository taskRepository;

        @Override
        public Task createTask(Task task) {
            return taskRepository.save(task);
        }

        @Override
        public List<Task> getAllTasks() {
            return taskRepository.findAll();
        }

        @Override
        public Optional<Task> getTaskById(Long i) {
            return taskRepository.findById(id);
        }

        @Override
        public Optional<Task> getTasksByUserId(Long userId) {
            return taskRepository.findByUserId(userId);
        }

        @Override
        public Task updateTask(Long id, Task taskDetails) {
            return taskRepository.findById(id).map(task -> {
                task.setTitle(taskDetails.getTitle());
                task.setDescription(taskDetails.getDescription());
                task.setDueDate(taskDetails.getDueDate());
                return taskRepository.save(task);
            }).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        }

        @Override
        public void deleteTask(Long id) {
            taskRepository.deleteById(id);
        }
}
