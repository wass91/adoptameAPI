package com.adoptame.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adoptame.services.entities.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Integer>{
	
}
