package com.adoptame.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptame.services.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
}
