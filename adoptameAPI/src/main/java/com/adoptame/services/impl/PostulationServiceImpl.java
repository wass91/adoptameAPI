package com.adoptame.services.impl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.adoptame.services.PostulationService;
import com.adoptame.services.entities.Pet;
import com.adoptame.services.entities.Postulation;
import com.adoptame.services.entities.User;
import com.adoptame.services.repositories.PetRepository;
import com.adoptame.services.repositories.PostulationRepository;
import com.adoptame.services.repositories.UserRepository;

@Service
public class PostulationServiceImpl implements PostulationService{
	
	@Autowired
	private PostulationRepository postulationRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Postulation> getAll(Integer page, Integer limit) throws Exception {
		Page<Postulation> pagePostulation = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pagePostulation = postulationRepository.findAll(pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pagePostulation;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Postulation create(boolean active, Date postulationDate, Integer userId, Integer petId) throws Exception {
		Postulation postulation = null;
		try {
			postulation = new Postulation();
			User user = userRepository.findOne(userId);
			Pet pet = petRepository.findOne(petId);
			postulation.setActive(active);
			postulation.setUser(user);
			postulation.setPet(pet);
			postulation.setPostulationDate(postulationDate);
			postulation = postulationRepository.saveAndFlush(postulation);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return postulation;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Postulation update(Integer id, boolean active, Date postulationDate, Integer userId, Integer petId)
			throws Exception {
		Postulation postulation = null;
		try {
			postulation = postulationRepository.findOne(id);
			if(postulation == null){
				throw new Exception("Adoption not found");
			}
			User user = userRepository.findOne(userId);
			Pet pet = petRepository.findOne(petId);
			postulation.setActive(active);
			postulation.setUser(user);
			postulation.setPet(pet);
			postulation.setPostulationDate(postulationDate);
			postulation = postulationRepository.saveAndFlush(postulation);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return postulation;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Postulation getById(Integer id) throws Exception {
		Postulation postulation = null;
		try {
			postulation = postulationRepository.findOne(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return postulation;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Postulation> getBySpecie(Integer specieId, Integer page, Integer limit) throws Exception {
		Page<Postulation> pagePostulations = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pagePostulations = postulationRepository.findBySpecieId(specieId, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pagePostulations;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Postulation> getByBreed(Integer breedId, Integer page, Integer limit) throws Exception {
		Page<Postulation> pagePostulation = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pagePostulation = postulationRepository.findByBreedId(breedId, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pagePostulation;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Postulation> getByPet(Integer petId, Integer page, Integer limit) throws Exception {
		Page<Postulation> pagePostulation = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pagePostulation = postulationRepository.findByPetId(petId, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pagePostulation;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Postulation> getByUser(Integer userId, Integer page, Integer limit) throws Exception {
		Page<Postulation> pagePostulations = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pagePostulations = postulationRepository.findByUserId(userId, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pagePostulations;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Postulation> getByActive(boolean active, Integer page, Integer limit) throws Exception {
		Page<Postulation> pagePostulations = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pagePostulations = postulationRepository.findByActive(true, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pagePostulations;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public boolean activatePostulation(Integer id, boolean active) throws Exception {
		Postulation postulation = null;
		try {
			postulation = postulationRepository.findOne(id);
			if(postulation == null){
				throw new Exception("Not adoption found");
			}
			postulation.setActive(active);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return postulation.getActive();
	}
	
}
