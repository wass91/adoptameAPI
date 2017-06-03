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

import com.adoptame.services.VaccineService;
import com.adoptame.services.entities.Vaccine;
import com.adoptame.services.repositories.VaccineRepository;

@Service
public class VaccineServiceImpl implements VaccineService{

	@Autowired
	private VaccineRepository vaccineRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Vaccine> getAll(Integer page, Integer limit) throws Exception {
		Page<Vaccine> pageVaccines = null;		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		Sort sortObject = new Sort(order);
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pageVaccines = vaccineRepository.findAll(pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pageVaccines;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Vaccine create(String name) throws Exception {
		Vaccine vaccine = null;
		try {
			vaccine = new Vaccine();
			vaccine.setName(name);
			vaccine = vaccineRepository.saveAndFlush(vaccine);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return vaccine;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Vaccine getById(Integer id) throws Exception {
		Vaccine vaccine = null;
		try {
			vaccine = vaccineRepository.findOne(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return vaccine;
	}

	@Override
	public Vaccine update(Integer id, String name) throws Exception {
		Vaccine vaccine = null;
		vaccine = vaccineRepository.findOne(id);
		if(vaccine == null){
			throw new Exception("Specie not found");
		}
		try {
			vaccine.setName(name);
			vaccine = vaccineRepository.saveAndFlush(vaccine);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return vaccine;
	}
	
}
