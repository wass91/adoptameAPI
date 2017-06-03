package com.adoptame.services;

import org.springframework.data.domain.Page;

import com.adoptame.services.entities.Breed;

public interface BreedService {
	public Page<Breed> getAll(Integer page, Integer limit) throws Exception;
	
	public Breed create(String name, Integer specieId) throws Exception;
	
	public Breed update(Integer id, String name, Integer specieId) throws Exception;
	
	public Breed getById(Integer id) throws Exception;
	
	public Page<Breed> getBySpecie(Integer id,Integer page, Integer limit) throws Exception;
}
