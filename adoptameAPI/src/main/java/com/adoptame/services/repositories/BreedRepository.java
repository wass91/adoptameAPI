package com.adoptame.services.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adoptame.services.entities.Breed;

public interface BreedRepository extends JpaRepository<Breed, Integer>{
	
	@Query("SELECT b FROM Breed b WHERE b.specie.id = ?1")
	public Page<Breed> findBySpecieId(Integer specieId, Pageable pageable); 
	
}
