package com.adoptame.services;


import java.util.Date;

import org.springframework.data.domain.Page;

import com.adoptame.services.entities.Postulation;

public interface PostulationService {
	
	public Page<Postulation> getAll(Integer page, Integer limit) throws Exception;
	
	public Postulation create(boolean active, Date postulationDate, Integer userId, Integer petId) throws Exception;
	
	public Postulation update(Integer id, boolean active, Date postulationDate, Integer userId, Integer petId) throws Exception;
	
	public Postulation getById(Integer id) throws Exception;
	
	public Page<Postulation> getBySpecie(Integer specieId,Integer page, Integer limit) throws Exception;
	
	public Page<Postulation> getByBreed(Integer beedId,Integer page, Integer limit) throws Exception;
	
	public Page<Postulation> getByPet(Integer petId,Integer page, Integer limit) throws Exception;

	public Page<Postulation> getByUser(Integer userId,Integer page, Integer limit) throws Exception;
	
	public Page<Postulation> getByActive(boolean active,Integer page, Integer limit) throws Exception;
	
	public boolean activatePostulation(Integer id, boolean active) throws Exception;
}
