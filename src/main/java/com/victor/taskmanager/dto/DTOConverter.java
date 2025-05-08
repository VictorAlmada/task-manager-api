package com.victor.taskmanager.dto;

import com.victor.taskmanager.model.Task;
import com.victor.taskmanager.model.User;

public class DTOConverter {

	// USER ----> DTO
	public static UserDTO toUserDTO(User user) {
		if (user == null)
			return null; // Validamos null para evitar NullPointerException.
		return new UserDTO(user.getId(), user.getNome(), user.getEmail());
	}

	// TASK ----> DTO
	public static TaskDTO toTaskDTO(Task task) {
		if (task == null)
			return null; // Validamos null para evitar NullPointerException.
		return new TaskDTO(task.getId(), task.getTitle(), task.getDescription(), task.getDueDate(),
				task.getPriority().name(), // Usamos .name() para transformar o enum em String.
				task.getStatus().name(), // Usamos .name() para transformar o enum em String.
				task.getUser() != null ? task.getUser().getId() : null // Validamos null para evitar
																		// NullPointerException.
		);
	}

	// DTO ----> TASK (USADO EM CRIAÇÃO)
	public static Task toTaskEntity(TaskCreateDTO dto, User user) {
		Task task = new Task();
		task.setTitle(dto.getTitle());
		task.setDescription(dto.getDescription());
		task.setDueDate(dto.getDueDate());
		task.setPriority(Enum.valueOf(com.victor.taskmanager.model.enums.Priority.class, dto.getPriority()));
		task.setStatus(Enum.valueOf(com.victor.taskmanager.model.enums.Status.class, dto.getStatus()));
		task.setUser(user);
		return task;
		// Usamos Enum.valurOf() para transformar String em Enum
	}
}
