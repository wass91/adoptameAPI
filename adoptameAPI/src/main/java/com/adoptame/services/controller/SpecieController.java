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
import com.adoptame.services.ServiceDirectory;
import com.adoptame.services.SpecieService;
import com.adoptame.services.entities.Specie;
import com.adoptame.services.json.Response;

@RestController
public class SpecieController extends BaseController{
	
	@Autowired
	private SpecieService specieService;
	
	@RequestMapping(value = ServiceDirectory.SPECIE_GET_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getAll(@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Specie> species = null;
		try {
			species = specieService.getAll(--page, limit);
			response = this.createResponse(species.getContent());
			Long total = species.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.SPECIE_CREATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response create(@RequestParam String name){
		Response response = null;
		Specie specie = null;
		try {
			specie = specieService.create(name);
			response = this.createResponse(specie);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.SPECIE_UPDATE, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response update(@RequestParam Integer specieId, @RequestParam String name){
		Response response = null;
		Specie specie = null;
		try {
			specie = specieService.update(specieId, name);
			response = this.createResponse(specie);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.SPECIE_GET_BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getById(@RequestParam Integer id){
		Response response = null;
		try {
			response = createResponse(specieService.getById(id));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
}
