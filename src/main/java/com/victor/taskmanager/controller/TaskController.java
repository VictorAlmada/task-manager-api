package com.victor.taskmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.taskmanager.dto.TaskCreateDTO;
import com.victor.taskmanager.dto.TaskDTO;
import com.victor.taskmanager.service.TaskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
	
	private final TaskService taskService;
	
	@GetMapping
	public List<TaskDTO> getAllTasks() {
		List<TaskDTO> list  = taskService.findAll();
		return list;
	}
	
	@GetMapping("/{id}")
	public TaskDTO getTaskById(@PathVariable Long id) {
		return taskService.findById(id);
	}
	
	@PostMapping
	public TaskDTO createTask(@RequestBody TaskCreateDTO dto) {
		return taskService.create(dto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskService.delete(id);
	}
	
}
