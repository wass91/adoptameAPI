package com.adoptame.services.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adoptame.services.entities.Postulation;

public interface PostulationRepository extends JpaRepository<Postulation, Integer>{

	@Query("SELECT p FROM Postulation p WHERE p.pet.specie.id = ?1")
	public Page<Postulation> findBySpecieId(Integer specieId, Pageable pageable);
	
	@Query("SELECT p FROM Postulation p WHERE p.pet.breed.id = ?1")
	public Page<Postulation> findByBreedId(Integer breedId, Pageable pageable);
	
	@Query("SELECT p FROM Postulation p WHERE p.user.id = ?1")
	public Page<Postulation> findByUserId(Integer userId, Pageable pageable);
	
	@Query("SELECT p FROM Postulation p WHERE p.pet.id = ?1")
	public Page<Postulation> findByPetId(Integer petId, Pageable pageable);

	@Query("SELECT p FROM Postulation p WHERE p.pet.id = ?1")
	public List<Postulation> findByPetId(Integer petId);
	
	public Page<Postulation> findByActive(boolean active, Pageable pageable);
	
}
