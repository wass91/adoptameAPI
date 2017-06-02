package com.adoptame.services.impl;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.adoptame.services.AdoptionService;
import com.adoptame.services.entities.Adoption;

@Service
public class AdoptionServiceImpl implements AdoptionService{

	@Override
	public Adoption getAdoption(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Adoption> getAllAdoptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Adoption> getAdoptionsByUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Adoption> getAdoptionsByBreed(int breedId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adoption getAdoptionsByPet(int petId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
