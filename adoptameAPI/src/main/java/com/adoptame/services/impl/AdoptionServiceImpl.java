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

import com.adoptame.services.AdoptionService;
import com.adoptame.services.PostService;
import com.adoptame.services.entities.Adoption;
import com.adoptame.services.entities.Pet;
import com.adoptame.services.entities.Post;
import com.adoptame.services.entities.User;
import com.adoptame.services.repositories.AdoptionRepository;
import com.adoptame.services.repositories.PetRepository;
import com.adoptame.services.repositories.UserRepository;

@Service
public class AdoptionServiceImpl implements AdoptionService{
	
	@Autowired
	private AdoptionRepository adoptionRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostService postService; 
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Adoption> getAll(Integer page, Integer limit) throws Exception {
		Page<Adoption> pageAdoptions = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pageAdoptions = adoptionRepository.findAll(pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pageAdoptions;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Adoption create(boolean active, Date adoptionDate, Integer userId, Integer petId) throws Exception {
		Adoption adoption = null;
		try {
			adoption = new Adoption();
			User user = userRepository.findOne(userId);
			Pet pet = petRepository.findOne(petId);
			Post post = postService.getByPet(petId, 0, 0);
			adoption.setActive(active);
			adoption.setUser(user);
			adoption.setPet(pet);
			adoption = adoptionRepository.saveAndFlush(adoption);
			postService.activatePost(post.getId(), false);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return adoption;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Adoption update(Integer id, boolean active, Date adoptionDate, Integer userId, Integer petId)
			throws Exception {
		Adoption adoption = null;
		try {
			adoption = adoptionRepository.findOne(id);
			if(adoption == null){
				throw new Exception("Adoption not found");
			}
			User user = userRepository.findOne(userId);
			Pet pet = petRepository.findOne(petId);
			adoption.setActive(active);
			adoption.setUser(user);
			adoption.setPet(pet);
			adoption = adoptionRepository.saveAndFlush(adoption);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return adoption;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Adoption getById(Integer id) throws Exception {
		Adoption adoption = null;
		try {
			adoption = adoptionRepository.findOne(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return adoption;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Adoption> getBySpecie(Integer specieId, Integer page, Integer limit) throws Exception {
		Page<Adoption> pageAdoptions = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pageAdoptions = adoptionRepository.findBySpecieId(specieId, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pageAdoptions;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Adoption> getByBreed(Integer breedId, Integer page, Integer limit) throws Exception {
		Page<Adoption> pageAdoptions = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pageAdoptions = adoptionRepository.findByBreedId(breedId, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pageAdoptions;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Adoption getByPet(Integer petId, Integer page, Integer limit) throws Exception {
		Adoption adoption = null;
		
		try {
			adoption = adoptionRepository.findByPetId(petId);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return adoption;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Adoption> getByUser(Integer userId, Integer page, Integer limit) throws Exception {
		Page<Adoption> pageAdoptions = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pageAdoptions = adoptionRepository.findByUserId(userId, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pageAdoptions;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Adoption> getByActive(boolean active, Integer page, Integer limit) throws Exception {
		Page<Adoption> pageAdoptions = null;
		Sort sortObject = null;
		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		sortObject = new Sort(order);
		
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pageAdoptions = adoptionRepository.findByActive(true, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pageAdoptions;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public boolean activateAdoption(Integer id, boolean active) throws Exception {
		Adoption adoption = null;
		try {
			adoption = adoptionRepository.findOne(id);
			if(adoption == null){
				throw new Exception("Not adoption found");
			}
			adoption.setActive(active);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return adoption.getActive();
	}
	
}
