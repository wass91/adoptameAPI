package com.adoptame.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptame.services.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer>{
	
}
