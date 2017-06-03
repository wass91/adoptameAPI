package com.adoptame.services;


import org.springframework.data.domain.Page;

import com.adoptame.services.entities.Adoption;

public interface AdoptionService {
	
	public Adoption getAdoption(int id);
	
	public Page<Adoption> getAllAdoptions();
	
	public Page<Adoption> getAdoptionsByUser(int userId);
	
	public Page<Adoption> getAdoptionsByBreed(int breedId);
	
	public Adoption getAdoptionsByPet(int petId);
}
