package com.adoptame.services.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adoptame.services.AdoptionService;
import com.adoptame.services.BaseController;
import com.adoptame.services.ServiceDirectory;
import com.adoptame.services.entities.Adoption;
import com.adoptame.services.json.Response;

@RestController
public class AdoptionController extends BaseController{
	
	@Autowired
	private AdoptionService adoptionService;
	
	@RequestMapping(value = ServiceDirectory.ADOPTION_GET_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getAll(@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Adoption> adoptions = null;
		try {
			adoptions = adoptionService.getAll(--page, limit);
			response = this.createResponse(adoptions.getContent());
			Long total = adoptions.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.ADOPTION_CREATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response create(@RequestParam boolean active, @RequestParam String adoptionDate, @RequestParam Integer userId, 
			@RequestParam Integer petId){
		Response response = null;
		Adoption adoption = null;
		try {
			adoption = adoptionService.create(active, formatter.parse(adoptionDate), userId, petId);
			response = this.createResponse(adoption);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.ADOPTION_UPDATE, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response update(@RequestParam Integer adoptionId, @RequestParam boolean active, @RequestParam String adoptionDate, @RequestParam Integer userId, 
			@RequestParam Integer petId){
		Response response = null;
		Adoption adoption = null;
		try {
			adoption = adoptionService.update(adoptionId, active, formatter.parse(adoptionDate), userId, petId);
			response = this.createResponse(adoption);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.ADOPTION_GET_BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getById(@RequestParam Integer id){
		Response response = null;
		try {
			response = createResponse(adoptionService.getById(id));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.ADOPTION_GET_ACTIVE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getActive(@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Adoption> adoptions = null;
		try {
			adoptions = adoptionService.getByActive(true, --page, limit);
			response = this.createResponse(adoptions.getContent());
			Long total = adoptions.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.ADOPTION_ACTIVATE, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response activateAdoption(@RequestParam Integer id, @RequestParam boolean active){
		Response response = null;
		try {
			response = createResponse(adoptionService.activateAdoption(id, active));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.ADOPTION_GET_BY_PET, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getByPet(@RequestParam Integer petId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		try {
			response = createResponse(adoptionService.getByPet(petId, --page, limit));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.ADOPTION_GET_BY_SPECIE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getBySpecie(@RequestParam Integer specieId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Adoption> posts = null;
		try {
			posts = adoptionService.getBySpecie(specieId, --page, limit);
			response = this.createResponse(posts.getContent());
			Long total = posts.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.ADOPTION_GET_BY_BREED, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getByBreed(@RequestParam Integer breedId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Adoption> adoptions = null;
		try {
			adoptions = adoptionService.getByBreed(breedId, --page, limit);
			response = this.createResponse(adoptions.getContent());
			Long total = adoptions.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.ADOPTION_GET_BY_USER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getByUser(@RequestParam Integer userId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Adoption> adoptions = null;
		try {
			adoptions = adoptionService.getByUser(userId, --page, limit);
			response = this.createResponse(adoptions.getContent());
			Long total = adoptions.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
}
