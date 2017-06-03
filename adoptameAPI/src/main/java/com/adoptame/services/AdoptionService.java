package com.adoptame.services;


import java.util.Date;

import org.springframework.data.domain.Page;

import com.adoptame.services.entities.Adoption;

public interface AdoptionService {
	
	public Page<Adoption> getAll(Integer page, Integer limit) throws Exception;
	
	public Adoption create(boolean active, Date adoptionDate, Integer userId, Integer petId) throws Exception;
	
	public Adoption update(Integer id, boolean active, Date adoptionDate, Integer userId, Integer petId) throws Exception;
	
	public Adoption getById(Integer id) throws Exception;
	
	public Page<Adoption> getBySpecie(Integer specieId,Integer page, Integer limit) throws Exception;
	
	public Page<Adoption> getByBreed(Integer beedId,Integer page, Integer limit) throws Exception;
	
	public Adoption getByPet(Integer petId,Integer page, Integer limit) throws Exception;

	public Page<Adoption> getByUser(Integer userId,Integer page, Integer limit) throws Exception;
	
	public Page<Adoption> getByActive(boolean active,Integer page, Integer limit) throws Exception;
	
	public boolean activateAdoption(Integer id, boolean active) throws Exception;
}
