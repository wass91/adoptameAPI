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
import com.adoptame.services.VaccineService;
import com.adoptame.services.entities.Vaccine;
import com.adoptame.services.json.Response;

@RestController
public class VaccineController extends BaseController{
	
	@Autowired
	private VaccineService vaccineService;
	
	@RequestMapping(value = ServiceDirectory.VACCINE_GET_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getAll(@RequestParam Integer page, @RequestParam Integer limit){
		Response response = null;
		Page<Vaccine> vaccines = null;
		try {
			vaccines = vaccineService.getAll(--page, limit);
			response = this.createResponse(vaccines.getContent());
			Long total = vaccines.getTotalElements();
			response.setTotal(total.intValue());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.VACCINE_CREATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response create(@RequestParam String name){
		Response response = null;
		Vaccine vaccine = null;
		try {
			vaccine = vaccineService.create(name);
			response = this.createResponse(vaccine);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.VACCINE_UPDATE, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response update(@RequestParam Integer id, @RequestParam String name){
		Response response = null;
		Vaccine vaccine = null;
		try {
			vaccine = vaccineService.update(id, name);
			response = this.createResponse(vaccine);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.VACCINE_GET_BY_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getById(@RequestParam Integer id){
		Response response = null;
		try {
			response = createResponse(vaccineService.getById(id));
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
}
