package com.pet.budget_manager.repositories;

import com.pet.budget_manager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
