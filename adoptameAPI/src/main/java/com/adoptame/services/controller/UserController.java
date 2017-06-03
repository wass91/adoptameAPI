package com.adoptame.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adoptame.services.BaseController;
import com.adoptame.services.ServiceDirectory;
import com.adoptame.services.UserService;
import com.adoptame.services.entities.User;
import com.adoptame.services.json.Response;

@RestController
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = ServiceDirectory.USER_CREATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response create(@RequestParam String name, @RequestParam String email, @RequestParam String password){
		Response response = null;
		User user = null;
		try {
			user = userService.create(name, email, password);
			response = this.createResponse(user);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = ServiceDirectory.USER_LOGIN, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response login(@RequestParam String email, @RequestParam String password){
		Response response = null;
		User user = null;
		try {
			user = userService.login(email, password);
			response = this.createResponse(user);
		} catch (Exception e) {
			response = createErrorResponse(e.getMessage());
		}
		return response;
	}
}
