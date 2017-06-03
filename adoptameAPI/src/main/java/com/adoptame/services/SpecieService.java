package com.adoptame.services;


import org.springframework.data.domain.Page;

import com.adoptame.services.entities.Specie;

public interface SpecieService {
	
	public Page<Specie> getAll(Integer page, Integer limit) throws Exception;
	
	public Specie create(String name) throws Exception;
	
	public Specie update(Integer specieId, String name) throws Exception;
	
	public Specie getById(Integer specieId) throws Exception;
}
