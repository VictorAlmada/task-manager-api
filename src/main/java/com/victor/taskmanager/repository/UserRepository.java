package com.victor.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.taskmanager.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
