package com.adoptame.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adoptame.services.PetService;
import com.adoptame.services.entities.Breed;
import com.adoptame.services.entities.Pet;
import com.adoptame.services.entities.Specie;
import com.adoptame.services.entities.Vaccine;
import com.adoptame.services.repositories.BreedRepository;
import com.adoptame.services.repositories.PetRepository;
import com.adoptame.services.repositories.SpecieRepository;
import com.adoptame.services.repositories.VaccineRepository;

@Service
public class PetServiceImpl implements PetService{
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private BreedRepository breedRepository;
	
	@Autowired
	private SpecieRepository specieRepository; 
	
	@Autowired
	private VaccineRepository vaccineRepository; 

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Pet> getAll(Integer page, Integer limit) throws Exception {
		Page<Pet> pagePets = null;		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		Sort sortObject = new Sort(order);
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pagePets = petRepository.findAll(pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pagePets;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Pet create(Date birthdate, String image, boolean sterilized, Integer breedId, Integer specieId)
			throws Exception {
		Pet pet = null;
		try {
			Breed breed = breedRepository.findOne(breedId);
			Specie specie = specieRepository.findOne(specieId);
			pet = new Pet();
			pet.setBirthdate(birthdate);
			pet.setBreed(breed);
			pet.setSpecie(specie);
			pet.setImage(image);
			pet.setSterilized(sterilized);
			pet = petRepository.saveAndFlush(pet);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pet;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Pet update(Integer id, Date birthdate, String image, boolean sterilized, Integer breedId, Integer specieId)
			throws Exception {
		Pet pet = null;
		try {
			Breed breed = breedRepository.findOne(breedId);
			Specie specie = specieRepository.findOne(specieId);
			pet = petRepository.findOne(id);
			if(pet == null){
				throw new Exception("Not Pet found");
			}
			pet.setBirthdate(birthdate);
			pet.setBreed(breed);
			pet.setSpecie(specie);
			pet.setImage(image);
			pet.setSterilized(sterilized);
			pet = petRepository.saveAndFlush(pet);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pet;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Pet getById(Integer id) throws Exception {
		Pet pet = null;
		try {
			pet = petRepository.findOne(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pet;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Pet> getBySpecie(Integer specieId, Integer page, Integer limit) throws Exception {
		Page<Pet> pagePets = null;		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		Sort sortObject = new Sort(order);
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pagePets = petRepository.findPetsFromSpecie(specieId, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pagePets;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Page<Pet> getByBreed(Integer breedId, Integer page, Integer limit) throws Exception {
		Page<Pet> pagePets = null;		
		Direction dir = Sort.Direction.ASC;
		Order order = new Order(dir, "id");
		Sort sortObject = new Sort(order);
		try {
			PageRequest pageable = new PageRequest(page,limit, sortObject);
			pagePets = petRepository.findPetsFromBreed(breedId, pageable);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pagePets;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public List<Vaccine> addVaccine(Integer petId, Integer vaccineId) throws Exception {
		Pet pet = null;
		try {
			pet = petRepository.findOne(petId);
			Vaccine vaccine = vaccineRepository.findOne(vaccineId);
			if(pet.getVaccineCollection() == null){
				List<Vaccine> vaccines = new ArrayList<>();
				vaccines.add(vaccine);
				pet.setVaccineCollection(vaccines);
			}else{
				pet.getVaccineCollection().add(vaccine);
			}
			pet = petRepository.saveAndFlush(pet);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pet != null ? pet.getVaccineCollection():null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public List<Vaccine> removeVaccine(Integer petId, Integer vaccineId) throws Exception {
		Pet pet = null;
		try {
			pet = petRepository.findOne(petId);
			Vaccine vaccine = vaccineRepository.findOne(vaccineId);
			if(pet.getVaccineCollection() != null && !pet.getVaccineCollection().isEmpty()){
				pet.getVaccineCollection().add(vaccine);
				pet = petRepository.saveAndFlush(pet);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pet != null ? pet.getVaccineCollection():null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public List<Vaccine> listVaccines(Integer petId) throws Exception {
		Pet pet = null;
		try {
			pet = petRepository.findOne(petId);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return pet != null ? pet.getVaccineCollection():null;
	}

}
