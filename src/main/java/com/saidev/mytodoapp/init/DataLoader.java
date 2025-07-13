package com.saidev.mytodoapp.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.saidev.mytodoapp.entity.Task;
import com.saidev.mytodoapp.repository.TaskRepository;

@Component
public class DataLoader implements CommandLineRunner {
    private final TaskRepository taskRepository;

    public DataLoader(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) {
        if (taskRepository.count() == 0) {
            taskRepository.save(new Task( "Sample Task 1", "This is your first task.", false));
            taskRepository.save(new Task( "Sample Task 2", "This is your second task.", true));
        }
    }
}

