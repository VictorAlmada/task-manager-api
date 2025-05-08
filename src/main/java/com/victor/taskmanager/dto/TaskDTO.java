package com.victor.taskmanager.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
	
	private Long id;
	private String title;
	private String description;
	private LocalDate dueDate;
	private String priority;
	private String status;
	private Long userId;
	
}
