package com.pet.budget_manager.services;

import com.pet.budget_manager.entities.Task;


public interface TaskService {
    Task createTask(String title, boolean isCompleted);

    Task updateTask(Long id, String title, boolean completed);

    Task getTaskById(Long id);

    void deleteTaskById(Long id);
}
