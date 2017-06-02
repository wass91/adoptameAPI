package com.adoptame.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptame.services.entities.Breed;

public interface BreedRepository extends JpaRepository<Breed, Integer>{
	
}
