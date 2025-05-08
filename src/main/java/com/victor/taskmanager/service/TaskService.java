package com.victor.taskmanager.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.victor.taskmanager.dto.DTOConverter;
import com.victor.taskmanager.dto.TaskCreateDTO;
import com.victor.taskmanager.dto.TaskDTO;
import com.victor.taskmanager.exception.ResourceNotFoundException;
import com.victor.taskmanager.model.Task;
import com.victor.taskmanager.model.User;
import com.victor.taskmanager.repository.TaskRepository;
import com.victor.taskmanager.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
	
	private final TaskRepository taskRepository;
	private final UserRepository userRepository;
	
	
	// LISTAR TODOS
	public List<TaskDTO> findAll() {
		return taskRepository.findAll().stream().map(DTOConverter::toTaskDTO).collect(Collectors.toList());
	}
	
	// BUSCAR POR ID
	public TaskDTO findById(Long id) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com ID: " + id));
		return DTOConverter.toTaskDTO(task);
	}
	
	// CRIAR UMA TAREFA
	public TaskDTO create(TaskCreateDTO dto) {
		User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + dto.getUserId()));
				
		Task task = DTOConverter.toTaskEntity(dto, user);
		Task saved = taskRepository.save(task);
		
		return DTOConverter.toTaskDTO(saved);
	}
	
	// DELETAR
	public void delete(Long id) {
		if (!taskRepository.existsById(id)) {
			throw new ResourceNotFoundException("Tarefa não encontrada para exclusão com ID: " + id);
		}
		taskRepository.deleteById(id);
	}
	
}
