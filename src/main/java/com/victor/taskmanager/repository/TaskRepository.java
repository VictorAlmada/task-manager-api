package com.victor.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.taskmanager.model.Task;
import com.victor.taskmanager.model.User;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	// BUSCAR TAREFAS DE UM USUÁRIO ESPECIFICO
	List<Task> findByUser(User user);
}
