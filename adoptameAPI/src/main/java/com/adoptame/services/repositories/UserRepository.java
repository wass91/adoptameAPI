package com.adoptame.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptame.services.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
