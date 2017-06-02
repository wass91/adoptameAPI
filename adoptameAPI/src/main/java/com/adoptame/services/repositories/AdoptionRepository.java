package com.adoptame.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptame.services.entities.Adoption;

public interface AdoptionRepository extends JpaRepository<Adoption, Integer>{
	
}
