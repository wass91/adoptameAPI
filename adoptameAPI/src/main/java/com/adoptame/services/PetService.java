package com.adoptame.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.adoptame.services.entities.Pet;
import com.adoptame.services.entities.Vaccine;

public interface PetService {
	public Page<Pet> getAll(Integer page, Integer limit) throws Exception;
	
	public Pet create(Date birthdate, String image, boolean sterilized,
			Integer breedId, Integer specieId) throws Exception;
	
	public Pet update(Integer id, Date birthdate, String image, boolean sterilized,
			Integer breedId, Integer specieId) throws Exception;
	
	public Pet getById(Integer id) throws Exception;
	
	public Page<Pet> getBySpecie(Integer specieId,Integer page, Integer limit) throws Exception;
	
	public Page<Pet> getByBreed(Integer spreedId,Integer page, Integer limit) throws Exception;
	
	public List<Vaccine> addVaccine(Integer petId, Integer vaccineId) throws Exception;
	
	public List<Vaccine> removeVaccine(Integer petId, Integer vaccineId) throws Exception;
	
	public List<Vaccine> listVaccines(Integer petId) throws Exception;
}
