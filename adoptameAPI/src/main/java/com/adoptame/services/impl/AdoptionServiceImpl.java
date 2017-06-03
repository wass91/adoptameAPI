package com.adoptame.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.adoptame.services.AdoptionService;
import com.adoptame.services.entities.Adoption;
import com.adoptame.services.repositories.AdoptionRepository;

@Service
public class AdoptionServiceImpl implements AdoptionService{

	@Autowired
	private AdoptionRepository adoptionRepository;
	
	@Override
	public Adoption getAdoption(int id) {
		return null;
	}

	@Override
	public Page<Adoption> getAllAdoptions() {
		List<Adoption> list = adoptionRepository.findAll();
		list.size();
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
