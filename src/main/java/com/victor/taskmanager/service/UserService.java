package com.victor.taskmanager.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.victor.taskmanager.dto.DTOConverter;
import com.victor.taskmanager.dto.UserDTO;
import com.victor.taskmanager.model.User;
import com.victor.taskmanager.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	
	public List<UserDTO> findAll() {
		List<UserDTO> list = userRepository.findAll().stream().map(DTOConverter::toUserDTO).collect(Collectors.toList());
		return list;
	}
	
	public UserDTO findById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
		return DTOConverter.toUserDTO(user);
		
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	
}
