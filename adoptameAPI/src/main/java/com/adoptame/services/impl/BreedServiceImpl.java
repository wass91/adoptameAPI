package com.adoptame.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adoptame.services.BreedService;
import com.adoptame.services.entities.Breed;
import com.adoptame.services.entities.Specie;
import com.adoptame.services.repositories.BreedRepository;
import com.adoptame.services.repositories.SpecieRepository;

@Service
public class BreedServiceImpl implements BreedService{

	@Autowired
	private BreedRepository breedRepository;
	
	@Autowired
	private SpecieRepository specieRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Breed> getAll(Integer page, Integer limit) throws Exception {
		Page<Breed> pageBreeds = null;		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		Sort sortObject = new Sort(order);
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pageBreeds = breedRepository.findAll(pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pageBreeds;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Breed create(String name, Integer specieId) throws Exception {
		Breed breed = null;
		Specie specie = null;
		try {
			specie = specieRepository.findOne(specieId);
			breed = new Breed();
			if(specie != null){
				breed.setSpecie(specie);
			}
			breed.setName(name);
			breed = breedRepository.saveAndFlush(breed);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return breed;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Breed update(Integer id, String name, Integer specieId) throws Exception {
		Breed breed = null;
		Specie specie = null;
		try {
			breed = breedRepository.findOne(id);
			if(breed == null){
				throw new Exception("Breed not found");
			}
			specie = specieRepository.findOne(specieId);
			if(specie != null){
				breed.setSpecie(specie);
			}
			if(name != null && !name.equals("")){
				breed.setName(name);
			}
			breed = breedRepository.saveAndFlush(breed);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return breed;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Breed getById(Integer id) throws Exception {
		Breed breed = null;
		try {
			breed = breedRepository.findOne(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return breed;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Breed> getBySpecie(Integer id, Integer page, Integer limit) throws Exception {
		Page<Breed> pageBreeds = null;		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		Sort sortObject = new Sort(order);
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pageBreeds = breedRepository.findBySpecieId(id, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pageBreeds;
	}

}
