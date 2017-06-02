package com.adoptame.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptame.services.entities.Specie;

public interface SpecieRepository extends JpaRepository<Specie, Integer>{
	
}
