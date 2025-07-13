package com.saidev.mytodoapp.controller;

import com.saidev.mytodoapp.entity.Task;
import com.saidev.mytodoapp.service.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskControllerTests {
    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    public TaskControllerTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTasks() {
        Task task1 = new Task("Task 1", "Desc 1", false);
        Task task2 = new Task("Task 2", "Desc 2", true);
        Mockito.when(taskService.getAllTasks()).thenReturn(Arrays.asList(task1, task2));
        List<Task> tasks = taskController.getAllTasks();
        assertEquals(2, tasks.size());
    }

    @Test
    void testGetTaskById_Found() {
        Task task = new Task("Task 1", "Desc 1", false);
        Mockito.when(taskService.getTaskById(1L)).thenReturn(Optional.of(task));
        ResponseEntity<Task> response = taskController.getTaskById(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(task, response.getBody());
    }

    @Test
    void testGetTaskById_NotFound() {
        Mockito.when(taskService.getTaskById(1L)).thenReturn(Optional.empty());
        ResponseEntity<Task> response = taskController.getTaskById(1L);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testCreateTask() {
        Task task = new Task("Task 1", "Desc 1", false);
        Mockito.when(taskService.createTask(task)).thenReturn(task);
        Task created = taskController.createTask(task);
        assertEquals(task, created);
    }

    @Test
    void testUpdateTask_Found() {
        Task update = new Task("Updated", "Updated Desc", true);
        Mockito.when(taskService.updateTask(1L, update)).thenReturn(Optional.of(update));
        ResponseEntity<Task> response = taskController.updateTask(1L, update);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Updated", response.getBody().getTitle());
    }

    @Test
    void testUpdateTask_NotFound() {
        Task update = new Task("Updated", "Updated Desc", true);
        Mockito.when(taskService.updateTask(1L, update)).thenReturn(Optional.empty());
        ResponseEntity<Task> response = taskController.updateTask(1L, update);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testDeleteTask_Found() {
        Mockito.when(taskService.deleteTask(1L)).thenReturn(true);
        ResponseEntity<Void> response = taskController.deleteTask(1L);
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    void testDeleteTask_NotFound() {
        Mockito.when(taskService.deleteTask(1L)).thenReturn(false);
        ResponseEntity<Void> response = taskController.deleteTask(1L);
        assertEquals(404, response.getStatusCodeValue());
    }
}
