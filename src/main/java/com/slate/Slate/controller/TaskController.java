package com.slate.Slate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slate.Slate.dto.TaskRequestDTO;
import com.slate.Slate.dto.TaskResponseDTO;
import com.slate.Slate.entity.Task;
import com.slate.Slate.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/task/api")
public class TaskController {

    private final TaskService taskService;
    
    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskResponseDTO saveTask(@Valid @RequestBody TaskRequestDTO taskRequestDTO) {
        return taskService.createTask(taskRequestDTO);
    }
    
    @GetMapping("/{id}")
    public TaskResponseDTO getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    
    @GetMapping
    public List<TaskResponseDTO> getAllTasks(){
    	return taskService.getAllTasks();
    }
    
    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(@PathVariable Long id,@Valid @RequestBody TaskRequestDTO newTaskRequestDTO) {
    	return taskService.updateTask(id, newTaskRequestDTO);
    }
    
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
    	 taskService.deleteTask(id);
    }
}