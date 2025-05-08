package com.victor.taskmanager.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.victor.taskmanager.model.Task;
import com.victor.taskmanager.model.User;
import com.victor.taskmanager.model.enums.Priority;
import com.victor.taskmanager.model.enums.Status;
import com.victor.taskmanager.repository.TaskRepository;
import com.victor.taskmanager.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@Profile("!test") // não roda em perfil de teste, apenas dev e default
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {
	
	private final UserRepository userRepository;
	private final TaskRepository taskRepository;

	@Override
	public void run(String... args) throws Exception {
		
		// limpa os dados existentes
		taskRepository.deleteAll();
		userRepository.deleteAll();
		
		// cria usuários
		User u1 = userRepository.save(new User(null, "Maria Silva", "maria@email.com"));
		User u2 = userRepository.save(new User(null, "João Costa", "joao@email.com"));
		
		// cria tarefas
		Task t1 = new Task(null, "Estudar Spring Boot", "Focar em JPA e REST", LocalDate.now().plusDays(3), Priority.HIGH, Status.PENDING, u1);
		Task t2 = new Task(null, "Revisar Inglês", "Estudar phrasal verbs", LocalDate.now().plusDays(1), Priority.MEDIUM, Status.IN_PROGRESS, u1);
		Task t3 = new Task(null, "Levar carro para revisão", "Trocar óleo", LocalDate.now().plusDays(5), Priority.LOW, Status.PENDING, u2);
		taskRepository.saveAll(List.of(t1, t2, t3));
		
		
	}

}
