package com.slate.Slate.service;

import java.util.List;

import com.slate.Slate.dto.TaskRequestDTO;
import com.slate.Slate.dto.TaskResponseDTO;
import com.slate.Slate.entity.Task;

public interface TaskService {
	
	TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO);
	TaskResponseDTO getTaskById(Long id);
	List<TaskResponseDTO> getAllTasks();
	TaskResponseDTO updateTask(Long id, TaskRequestDTO taskRequestDTO);
    void deleteTask(Long id);
}
