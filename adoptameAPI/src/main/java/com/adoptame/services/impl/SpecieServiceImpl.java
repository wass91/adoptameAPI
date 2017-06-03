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

import com.adoptame.services.SpecieService;
import com.adoptame.services.entities.Specie;
import com.adoptame.services.repositories.SpecieRepository;

@Service
public class SpecieServiceImpl implements SpecieService{

	@Autowired
	private SpecieRepository specieRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Specie> getAll(Integer page, Integer limit) throws Exception {
		Page<Specie> pageSpecies = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pageSpecies = specieRepository.findAll(pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pageSpecies;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Specie create(String name) throws Exception {
		Specie specie = null;
		try {
			specie = new Specie();
			specie.setName(name);
			specie = specieRepository.saveAndFlush(specie);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return specie;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Specie update(Integer specieId, String name) throws Exception {
		Specie specie = null;
		specie = specieRepository.findOne(specieId);
		if(specie == null){
			throw new Exception("Specie not found");
		}
		try {
			specie.setName(name);
			specie = specieRepository.saveAndFlush(specie);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return specie;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Specie getById(Integer specieId) throws Exception {
		Specie specie = null;
		try {
			specie = specieRepository.findOne(specieId);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return specie;
	}

}
