package com.slate.Slate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.slate.Slate.dto.TaskRequestDTO;
import com.slate.Slate.dto.TaskResponseDTO;
import com.slate.Slate.entity.Task;
import com.slate.Slate.exception.TaskNotFoundException;
import com.slate.Slate.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	private final TaskRepository taskRepository;
	
	// constructor injection
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	private TaskResponseDTO toTaskResponseDTO(Task task) {
		return new TaskResponseDTO(
				task.getId(),
				task.getTitle(),
				task.getDescription(),
				task.isCompleted(),
				task.getCreatedAt(),
				task.getUpdatedAt()
				);
	}
	@Override
	public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {

	    Task task = new Task();

	    task.setTitle(taskRequestDTO.getTitle());
	    task.setDescription(taskRequestDTO.getDescription());
	    task.setCompleted(taskRequestDTO.isCompleted());

	    Task savedTask = taskRepository.save(task);
	

	    // Entity → ResponseDTO will come here
	    
	   return toTaskResponseDTO(savedTask);

	}
	
	@Override
	public TaskResponseDTO getTaskById(Long id) {
		Task task =  taskRepository.findById(id)
				.orElseThrow(()-> new TaskNotFoundException("Task with id " + id + " is not present!!"));
		
		return toTaskResponseDTO(task);
	}
	
	@Override
	public List<TaskResponseDTO> getAllTasks(){
		 return taskRepository.findAll()
		 .stream()
		 .map(this::toTaskResponseDTO)
		 .toList();
	}
	
	@Override
	public TaskResponseDTO updateTask(Long id, TaskRequestDTO newTaskRequestDTO) {
		Task task =  taskRepository.findById(id).orElseThrow(()-> new TaskNotFoundException("Task with id "+id+" not found"));
		
		task.setTitle(newTaskRequestDTO.getTitle());
		task.setDescription(newTaskRequestDTO.getDescription());
		task.setCompleted(newTaskRequestDTO.isCompleted());
		
		 Task savedTask = taskRepository.save(task);
		
		return toTaskResponseDTO(savedTask);
	}
	
	@Override
	public void deleteTask(Long id) {
		taskRepository.findById(id).orElseThrow(()-> new TaskNotFoundException("Task with id "+id+" not found"));
		
		taskRepository.deleteById(id);
	}
}	
