package com.adoptame.services;

import com.adoptame.services.json.Response;
import com.adoptame.services.security.SecurityService;

public abstract class BaseController extends SecurityService{
	
	public Response createResponse(Object items){
		Response response = new Response();
		response.setItems(items);
		response.setSuccess(true);
		return response;
	}
	
	public Response createErrorResponse(String message){
		Response response = new Response();
		response.setSuccess(false);
		response.setMessage(message);
		return response;
	}
	
}
