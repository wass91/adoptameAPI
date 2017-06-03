package com.adoptame.services.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adoptame.services.entities.Adoption;

public interface AdoptionRepository extends JpaRepository<Adoption, Integer>{

	@Query("SELECT p FROM Adoption p WHERE p.pet.specie.id = ?1")
	public Page<Adoption> findBySpecieId(Integer specieId, Pageable pageable);
	
	@Query("SELECT p FROM Adoption p WHERE p.pet.breed.id = ?1")
	public Page<Adoption> findByBreedId(Integer breedId, Pageable pageable);
	
	@Query("SELECT p FROM Adoption p WHERE p.user.id = ?1")
	public Page<Adoption> findByUserId(Integer userId, Pageable pageable);
	
	@Query("SELECT p FROM Adoption p WHERE p.pet.id = ?1")
	public Adoption findByPetId(Integer petId);
	
	public Page<Adoption> findByActive(boolean active, Pageable pageable);
	
}
