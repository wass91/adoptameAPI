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
import com.adoptame.services.PostulationService;
import com.adoptame.services.ServiceDirectory;
import com.adoptame.services.entities.Postulation;
import com.adoptame.services.json.Response;

@RestController
public class PostulationController extends BaseController{
	
	@Autowired
	private PostulationService postulationService;
	
	@RequestMapping(value = ServiceDirectory.POSTULATION_GET_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getAll(@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Postulation> postulations = null;
		try {
			postulations = postulationService.getAll(--page, limit);
			response = this.createResponse(postulations.getContent());
			Long total = postulations.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POSTULATION_CREATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response create(@RequestParam boolean active, @RequestParam String postulationDate, @RequestParam Integer userId, 
			@RequestParam Integer petId){
		Response response = null;
		Postulation postulation = null;
		try {
			postulation = postulationService.create(active, formatter.parse(postulationDate), userId, petId);
			response = this.createResponse(postulation);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POSTULATION_UPDATE, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response update(@RequestParam Integer adoptionId, @RequestParam boolean active, @RequestParam String postulationDate, @RequestParam Integer userId, 
			@RequestParam Integer petId){
		Response response = null;
		Postulation postulation = null;
		try {
			postulation = postulationService.update(adoptionId, active, formatter.parse(postulationDate), userId, petId);
			response = this.createResponse(postulation);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POSTULATION_GET_BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getById(@RequestParam Integer id){
		Response response = null;
		try {
			response = createResponse(postulationService.getById(id));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POSTULATION_GET_ACTIVE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getActive(@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Postulation> postulations = null;
		try {
			postulations = postulationService.getByActive(true, --page, limit);
			response = this.createResponse(postulations.getContent());
			Long total = postulations.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POSTULATION_ACTIVATE, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response activateAdoption(@RequestParam Integer id, @RequestParam boolean active){
		Response response = null;
		try {
			response = createResponse(postulationService.activatePostulation(id, active));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POSTULATION_GET_BY_PET, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getByPet(@RequestParam Integer petId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		try {
			response = createResponse(postulationService.getByPet(petId, --page, limit));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POSTULATION_GET_BY_SPECIE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getBySpecie(@RequestParam Integer specieId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Postulation> postulations = null;
		try {
			postulations = postulationService.getBySpecie(specieId, --page, limit);
			response = this.createResponse(postulations.getContent());
			Long total = postulations.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POSTULATION_GET_BY_BREED, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getByBreed(@RequestParam Integer breedId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Postulation> postulations = null;
		try {
			postulations = postulationService.getByBreed(breedId, --page, limit);
			response = this.createResponse(postulations.getContent());
			Long total = postulations.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.POSTULATION_GET_BY_USER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getByUser(@RequestParam Integer userId,@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Postulation> postulations = null;
		try {
			postulations = postulationService.getByUser(userId, --page, limit);
			response = this.createResponse(postulations.getContent());
			Long total = postulations.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
}
