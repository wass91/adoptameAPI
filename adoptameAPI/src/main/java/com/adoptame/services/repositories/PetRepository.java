package com.adoptame.services.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adoptame.services.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer>{
	
	@Query("SELECT p FROM Pet p WHERE p.specie.id = ?1")
	public Page<Pet> getPetsFromSpecie(Integer specieId, Pageable pageable);
	
	@Query("SELECT p FROM Pet p WHERE p.breed.id = ?1")
	public Page<Pet> getPetsFromBreed(Integer breedId, Pageable pageable);
	
}
