package com.adoptame.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adoptame.services.BaseController;
import com.adoptame.services.BreedService;
import com.adoptame.services.ServiceDirectory;
import com.adoptame.services.entities.Breed;
import com.adoptame.services.json.Response;

@RestController
public class BreedController extends BaseController{
	
	@Autowired
	private BreedService breedService;
	
	@RequestMapping(value = ServiceDirectory.BREED_GET_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getAll(@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Breed> breeds = null;
		try {
			breeds = breedService.getAll(--page, limit);
			response = this.createResponse(breeds.getContent());
			Long total = breeds.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.BREED_CREATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response create(@RequestParam String name, @RequestParam Integer specieId){
		Response response = null;
		Breed breed = null;
		try {
			breed = breedService.create(name, specieId);
			response = this.createResponse(breed);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.BREED_UPDATE, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response update(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer specieId){
		Response response = null;
		Breed breed = null;
		try {
			breed = breedService.update(id, name, specieId);
			response = this.createResponse(breed);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.BREED_GET_BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getById(@RequestParam Integer id){
		Response response = null;
		try {
			response = createResponse(breedService.getById(id));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.BREED_GET_BY_SPECIE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getAllBySpecie(@RequestParam Integer specieId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Breed> breeds = null;
		try {
			breeds = breedService.getBySpecie(specieId, --page, limit);
			response = this.createResponse(breeds.getContent());
			Long total = breeds.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
}
