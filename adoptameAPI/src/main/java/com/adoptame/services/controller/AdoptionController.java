package com.adoptame.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.adoptame.services.AdoptionService;
import com.adoptame.services.BaseController;
import com.adoptame.services.json.Response;

@Controller
@RequestMapping(value = "/adoptions")
public class AdoptionController extends BaseController{
	
	@Autowired
	private AdoptionService adoptionService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response getAllAdoptions(){
		Response response = null;
		try {
			response = this.createResponse(adoptionService.getAllAdoptions());
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
}
