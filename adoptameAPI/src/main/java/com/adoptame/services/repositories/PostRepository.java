package com.adoptame.services.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adoptame.services.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

	@Query("SELECT p FROM Post p WHERE p.pet.specie.id = ?1")
	public Page<Post> findBySpecieId(Integer specieId, Pageable pageable);
	
	@Query("SELECT p FROM Post p WHERE p.pet.breed.id = ?1")
	public Page<Post> findByBreedId(Integer breedId, Pageable pageable);
	
	@Query("SELECT p FROM Post p WHERE p.user.id = ?1")
	public Page<Post> findByUserId(Integer userId, Pageable pageable);
	
	@Query("SELECT p FROM Post p WHERE p.pet.id = ?1")
	public Post findByPetId(Integer petId);
	
	public Page<Post> findByActive(boolean active, Pageable pageable);
}
