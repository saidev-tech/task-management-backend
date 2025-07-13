package com.saidev.mytodoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saidev.mytodoapp.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // No additional methods needed for basic CRUD
}

