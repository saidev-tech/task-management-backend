package com.saidev.mytodoapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.saidev.mytodoapp.entity.Task;
import com.saidev.mytodoapp.repository.TaskRepository;

@SpringBootApplication
public class MyTodoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyTodoAppApplication.class, args);
    }


}
